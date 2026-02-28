package com.example.pedido.controller;

import com.example.pedido.dto.PedidoRequest;
import com.example.pedido.dto.PedidoResponse;
import com.example.pedido.service.ServicePedido;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    ServicePedido service;

    public Controller(ServicePedido service) {
        this.service = service;
    }

    @GetMapping("/pedido/{id}")
    public PedidoResponse pedido(@PathVariable int id){


        //todo
        return null;
    }


    @PostMapping("/pedido")
    public PedidoResponse nuevoPedido(@RequestBody PedidoRequest pedidoRequest){
        return service.crearPedido(pedidoRequest);
    }
}
