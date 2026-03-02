package com.example.pedido.dto;

import com.example.pedido.entity.EstadoPedido;
import com.example.pedido.dto.LineaPedidoResponse;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponse {

    private Integer id;

    private EstadoPedido estadoPedido;
    private String cliente;
    private String anotacion;
    private LocalDateTime timestamp;
    private List<LineaPedidoResponse> lineas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public List<LineaPedidoResponse> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedidoResponse> lineas) {
        this.lineas = lineas;
    }

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

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
