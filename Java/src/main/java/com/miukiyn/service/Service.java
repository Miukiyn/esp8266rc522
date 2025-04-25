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
package com.miukiyn.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miukiyn.dao.DAO;
import com.miukiyn.model.Uid;

public class Service {

    // Método para buscar o UID no banco de dados
    public String buscaruid(spark.Request req, spark.Response res) {
        String uidCartao = req.queryParams("uid"); // Obtém o parâmetro 'uid' da query string

        // Busca o UID no banco
        Uid uid = buscarPorUid(uidCartao);

        // Se o UID foi encontrado, retorna o nome do usuário
        if (uid != null) {
            res.status(200); // 200 OK
            return "Usuário encontrado: " + uid.getNomeUsuario();
        } else {
            res.status(404); // 404 Not Found
            return "Cartão não encontrado.";
        }
    }

    // Método de busca no banco de dados
    private Uid buscarPorUid(String uidCartao) {
        Uid uid = null;
        String sql = "SELECT * FROM uid WHERE uid_cartao = ?";

        try (Connection conn = DAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, uidCartao);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                uid = new Uid();
                uid.setId(rs.getInt("id"));
                uid.setNomeUsuario(rs.getString("nome_usuario"));
                uid.setUidCartao(rs.getString("uid_cartao"));
            }

            rs.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar o UID no banco:");
            e.printStackTrace();
        }

        return uid;
    }
}
