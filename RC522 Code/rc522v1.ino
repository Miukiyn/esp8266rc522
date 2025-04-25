/**
 * -----------------------------------------------------------------------------
 * Projeto: Leitor RC522 com ESP8266
 * Repositório: https://github.com/Miukiyn/esp8266rc522
 * Versão: 1.0
 * 
 * Desenvolvido por: Miukiyn - Iago Adrien
 * 
 * Este código foi desenvolvido com o objetivo de integrar o módulo RFID RC522
 * com o microcontrolador ESP8266 para leitura de cartões ou tags RFID.
 * 
 * Direitos autorais reservados. Sinta-se livre para estudar e utilizar este código,
 * desde que os devidos créditos sejam mantidos.
 * -----------------------------------------------------------------------------
 */
 
#include <SPI.h>
#include <MFRC522.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

// Configuração do Wi-Fi
const char* ssid = "NAME";
const char* password = "PASSWORD";

// Endereço do servidor Node-RED
const char* serverUrl = "http://xxx.xxx.xx.x:1880/rfid";  // Substitua com o IP correto do seu Node-RED

// Pinos do leitor RFID
#define SS_PIN D4
#define RST_PIN D3
MFRC522 mfrc522(SS_PIN, RST_PIN);

void setup() {
  Serial.begin(115200);
  delay(1000);
  Serial.println(F("Iniciando..."));

  // Inicia SPI e RC522
  SPI.begin();
  mfrc522.PCD_Init();

  // Conecta no Wi-Fi
  WiFi.begin(ssid, password);
  Serial.print("Conectando ao WiFi");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("\nWiFi conectado!");

  // Verifica RC522
  byte version = mfrc522.PCD_ReadRegister(mfrc522.VersionReg);
  if (version == 0x00  version == 0xFF) {
    Serial.println(F("Falha ao comunicar com o RC522. Verifique conexões e alimentação."));
    while (true); // trava
  }

  Serial.print(F("RC522 detectado. Versão: 0x"));
  Serial.println(version, HEX);
  Serial.println(F("Aproxime o cartão..."));
}

void loop() {
  // Verifica se há novo cartão
  if (!mfrc522.PICC_IsNewCardPresent()  !mfrc522.PICC_ReadCardSerial()) return;

  // Constrói a string UID
  String uidStr = "";
  for (byte i = 0; i < mfrc522.uid.size; i++) {
    if (mfrc522.uid.uidByte[i] < 0x10) uidStr += "0";
    uidStr += String(mfrc522.uid.uidByte[i], HEX);
  }
  uidStr.toUpperCase();

  Serial.print("UID lido: ");
  Serial.println(uidStr);

  // Envia para o servidor Node-RED
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    WiFiClient client;
    http.begin(client, serverUrl);  // Conecta ao servidor Node-RED
    http.addHeader("Content-Type", "application/json");

    // JSON de dados
    String json = "{"uid":"" + uidStr + ""}";

    // Configura o timeout para a requisição HTTP
    http.setTimeout(5000);  // Timeout de 5 segundos

    // Envia a requisição POST
    int httpResponseCode = http.POST(json);

    // Verifica a resposta
    if (httpResponseCode > 0) {
      String response = http.getString();
      Serial.println("Resposta do Node-RED:");
      Serial.println(response);
    } else {
      Serial.print("Erro HTTP: ");
      Serial.println(httpResponseCode);
    }

    http.end();  // Finaliza a requisição HTTP
  } else {
    Serial.println("WiFi desconectado!");
  }

  mfrc522.PICC_HaltA();
  mfrc522.PCD_StopCrypto1();
  delay(3000);  // Aguarda 3 segundos antes de ler novamente
}