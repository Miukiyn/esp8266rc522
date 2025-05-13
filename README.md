# ESP8266 + RC522 - Controle de Acesso com Banco de Dados na Nuvem

Este projeto foi desenvolvido com o objetivo de **praticar conceitos de microcontroladores**, utilizando o **ESP8266** em conjunto com o módulo **RC522 (RFID)**. A ideia principal é registrar e controlar acessos por meio de cartões/tag RFID, integrando o sistema com **banco de dados na nuvem** através de **Java** e **Node-RED**.

## 🚀 Tecnologias Utilizadas

- **ESP8266** (microcontrolador com Wi-Fi)
- **RC522** (leitor RFID)
- **Node-RED** (plataforma de automação de fluxos)
- **Java** (para backend e conexão com banco de dados)
- **MySQL** (banco de dados na nuvem)

## 📌 Objetivos do Projeto

- Praticar a integração entre hardware (ESP8266) e software (Java/Node-RED).
- Criar uma solução funcional para controle de acesso com leitura RFID.
- Armazenar e consultar dados em tempo real usando banco de dados remoto.
- Aplicar conceitos de IoT, backend e segurança de dados (uso de `.env`).

## 💡 Como Funciona

1. O ESP8266 lê uma tag RFID via módulo RC522
2. A informação é enviada para o servidor via requisição HTTP.
3. O backend consulta os dados em um banco de dados MySQL na nuvem.
4. Os dados podem ser exibidos e monitorados em tempo real.

## 🔓 Licença e Uso

Este projeto é **livre para uso e modificação**. Sinta-se à vontade para estudar, adaptar ou expandir para suas próprias aplicações, desde que os devidos créditos sejam mantidos.

---

## 📎 Documentação

Você pode acessar a documentação do projeto aqui:  
[Documentação](https://github.com/Miukiyn/esp8266rc522/blob/main/Documentation/DOCUMENTATION.md)

---

Desenvolvido por **Iago Adrien** — com foco em aprendizado, prática e colaboração. 💻📡
