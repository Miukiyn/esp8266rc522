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
package com.miukiyn.model;

public class Uid{
    //Dados
    private int id;
    private String nomeUsuario;
    private String uidCartao;

    // Construtores
    public Uid() {}

    public Uid(String nomeUsuario, String uidCartao) {
        this.nomeUsuario = nomeUsuario;
        this.uidCartao = uidCartao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getUidCartao() {
        return uidCartao;
    }

    public void setUidCartao(String uidCartao) {
        this.uidCartao = uidCartao;
    }
}