package com.miukiyn.service;

import com.miukiyn.dao.DAO;
import com.miukiyn.model.Uid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Service {

    public Uid buscarPorUid(String uidCartao) {
        Uid uid = null;

        String sql = "SELECT * FROM cartoes WHERE uid_cartao = ?";

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

    public static void main(String[] args) {
        Service service = new Service();
        Uid resultado = service.buscarPorUid("123ABC456");

        if (resultado != null) {
            System.out.println("ID: " + resultado.getId());
            System.out.println("Usuário: " + resultado.getNomeUsuario());
            System.out.println("UID do Cartão: " + resultado.getUidCartao());
        } else {
            System.out.println("Cartão não encontrado.");
        }
    }
}
