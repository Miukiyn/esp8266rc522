#include <SPI.h>
#include <MFRC522.h>

#define SS_PIN D4  // SDA do RC522
#define RST_PIN D3 // RST do RC522

MFRC522 mfrc522(SS_PIN, RST_PIN); // Cria o objeto do sensor

void setup() {
  Serial.begin(115200);
  delay(1000);
  Serial.println(F("Iniciando..."));

  SPI.begin();  // Inicia comunicação SPI
  mfrc522.PCD_Init();  // Inicia o RC522

  // Verifica se o RC522 respondeu
  byte version = mfrc522.PCD_ReadRegister(mfrc522.VersionReg);
  if (version == 0x00 || version == 0xFF) {
    Serial.println(F("Falha ao comunicar com o RC522. Verifique conexões e alimentação."));
    while (true); // Para aqui
  }

  Serial.print(F("RC522 detectado. Versão: 0x"));
  Serial.println(version, HEX);
  Serial.println(F("Aproxime o cartão..."));
}

void loop() {
  // Verifica se tem um novo cartão
  if (!mfrc522.PICC_IsNewCardPresent()) return;
  if (!mfrc522.PICC_ReadCardSerial()) return;

  // Imprime o UID
  Serial.print(F("UID do cartão: "));
  for (byte i = 0; i < mfrc522.uid.size; i++) {
    Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
    Serial.print(mfrc522.uid.uidByte[i], HEX);
  }
  Serial.println();

  // Para nova leitura
  mfrc522.PICC_HaltA();
  mfrc522.PCD_StopCrypto1();
  delay(1000);
}
