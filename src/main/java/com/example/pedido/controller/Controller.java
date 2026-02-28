package com.example.pedido.controller;

import com.example.pedido.model.PedidoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/pedido/{id}")
    public PedidoResponse pedido(@PathVariable int id){


        //todo
        return null;
    }
}
