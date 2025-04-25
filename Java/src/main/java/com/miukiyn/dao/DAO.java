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
package com.miukiyn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String URL = "URL";
    private static final String USER = "USER";
    private static final String PASSWORD = "PASSWORD";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
