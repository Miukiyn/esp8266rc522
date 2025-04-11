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