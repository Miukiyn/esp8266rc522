package com.miukiyn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static final String URL = "jdbc:mysql://esp82.mysql.database.azure.com:3306/controle_acesso?useSSL=true&requireSSL=true";
    private static final String USER = "esprc522";
    private static final String PASSWORD = ")8#MT%&v";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
