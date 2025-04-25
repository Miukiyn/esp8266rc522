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
package com.miukiyn.app;

import com.miukiyn.service.Service;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {

    public static void main(String[] args) {
        // Configura a porta onde o servidor vai rodar
        port(8080); // Porta 8080, por exemplo

        // Instancia o Service
        Service service = new Service();

        // Configura a rota GET para buscar o UID
        get("/buscaruid", (req, res) -> service.buscaruid(req, res));
    }
}
