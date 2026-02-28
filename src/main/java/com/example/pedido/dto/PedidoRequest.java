package com.example.pedido.dto;

import com.example.pedido.entity.EstadoPedido;

public class PedidoRequest{

    private String cliente;
    private String anotacion;

    public String getAnotacion() {
        return anotacion;
    }

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


}
