
# 📡 Projeto: Leitor RFID RC522 com ESP8266 + Node-RED + Java Backend

Este projeto tem como objetivo integrar um leitor RFID **RC522** com um microcontrolador **ESP8266**, enviando os dados lidos para um servidor **Node-RED**, que por sua vez repassa as informações para um backend em **Java** conectado a um **banco de dados** na nuvem.

---

## 🔧 1. Conexões entre ESP8266 e RC522

Abaixo estão os encaixes corretos entre os pinos do **ESP8266 (NodeMCU)** e o módulo **RC522**:

| RC522 | ESP8266 (NodeMCU) |
|-------|--------------------|
| SDA   | D4 (GPIO2)         |
| SCK   | D5 (GPIO14)        |
| MOSI  | D7 (GPIO13)        |
| MISO  | D6 (GPIO12)        |
| RST   | D3 (GPIO0)         |
| GND   | GND                |
| 3.3V  | 3V3                |

> **Observação:** Certifique-se de alimentar o RC522 com **3.3V** para evitar danos ao módulo.

---

## 🌐 2. Conexão do ESP8266 com o Node-RED

O código do ESP8266 conecta-se a uma rede Wi-Fi e envia o UID do cartão lido via **HTTP POST** para uma URL do **Node-RED**:

```cpp
const char* serverUrl = "http://<IP_DO_NODE_RED>:1880/rfid";
```



---

## ☕ 3. Executando o Projeto Java

Certifique-se de ter o [Maven](https://maven.apache.org/) instalado.

Para compilar e executar o projeto via terminal:

```bash
mvn compile exec:java
```

> Rode o comando acima **dentro da pasta onde está o `pom.xml`**.

---

## 🗄️ 4. Estrutura do Banco de Dados (MySQL)

A estrutura abaixo foi utilizada durante os testes e pode ser criada facilmente no seu banco MySQL:

```sql
-- 1. Criar o banco de dados
CREATE DATABASE controle_acesso;

-- 2. Usar o banco de dados criado
USE controle_acesso;

-- 3. Criar a tabela UID
CREATE TABLE UID (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100),
    uid_cartao VARCHAR(16) NOT NULL UNIQUE
);
```

---

## 📝 5. Tecnologias utilizadas

- ESP8266 (NodeMCU)
- Leitor RFID RC522
- Node-RED
- Java 
- Maven
- MySQL / azure (Opção utilizada no desenvolvimento, implemente o banco de dados da maneira que achar melhor.)

---

## 📂 6. Organização do Projeto

```
esp8266rc522/
├── java/
│   ├── .mvn/
│   ├── .vscode/
│   ├── src/
│   ├── target/
│   ├── pom.xml
├── node-red/
│   └── uidhttp.json
└── esp8266/
    └── rc522v1.ino
```

---

## 📄 7. Licença

Este projeto está aberto para estudo, modificação e uso livre, desde que os devidos **créditos sejam mantidos**.

**Desenvolvido por:** Miukiyn - Iago Adrien  
**Versão:** 1.0  
**Repositório:** [https://github.com/Miukiyn/esp8266rc522](https://github.com/Miukiyn/esp8266rc522)
