package com.miukiyn.app;

import com.miukiyn.service.Service;

import static spark.Spark.*;

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
