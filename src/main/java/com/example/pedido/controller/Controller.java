package com.example.pedido.controller;

import com.example.pedido.dto.LineaPedidoRequest;
import com.example.pedido.dto.PedidoRequest;
import com.example.pedido.dto.PedidoResponse;
import com.example.pedido.service.ServicePedido;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import java.util.List;

@RestController
public class Controller {

    ServicePedido service;

    public Controller(ServicePedido service) {
        this.service = service;
    }

    // POST    /pedidos                     → crear pedido
    /**
     * CREAR PEDIDO
     *
     * @param pedidoRequest
     * @return
     */
    @PostMapping("/pedidos")
    public PedidoResponse nuevoPedido(@RequestBody PedidoRequest pedidoRequest){
        return service.crearPedido(pedidoRequest);
    }

    // GET     /pedidos                     → lista sin líneas
    /**
     * OBTENER LISTA PEDIDOS SIN LINEAS
     *
     * @return
     */
    @GetMapping("/pedidos")
    public List<PedidoResponse> getPedidos(){
        return service.getPedidos();
    }


    // GET     /pedidos/{id}                → pedido con líneas
    /**
     * OBTENER PEDIDO POR ID CON LINEAS
     *
     * @param id
     * @return
     */
    @GetMapping("/pedido/{id}")
    public PedidoResponse pedido(@PathVariable int id){
        return service.getPedidoId(id);
    }

    //===========================================================

    // POST    /pedidos/{id}/lineas         → añadir línea
    /**
     * AGREGAR LINEAS A UN PEDIDO EXISTENTE
     *
     * @param lineaPedidoRequest
     * @return
     */
    @PostMapping("/pedidos/{id}/lineas")
    public void agregarLinea(@PathVariable int id, @RequestBody LineaPedidoRequest lineaPedidoRequest){
        PedidoResponse pr = new PedidoResponse();
        service.agregarLinea(id, lineaPedidoRequest);

    }

    //=============================================================

    // DELETE  /pedidos/{id}/lineas/{lineaId} → eliminar línea
    /**
     * ELIMINAR LINEA DE PEDIDO
     *
     * @param id
     * @param lineaId
     */
    @DeleteMapping("/pedidos/{id}/lineas/{lineaId}")
    public void borrarLinea(@RequestBody Integer id, @RequestBody int lineaId){


    }

    // DELETE  /pedidos/{id}                → borrar pedido
    /**
     * BORRAR PEDIDO
     * @param id
     */
    @DeleteMapping("/pedidos/{id}")
    public void borrarPedido(@RequestBody int id){

    }



    // PUT     /pedidos/{id}                → actualizar pedido
    /**
     * ACTUALIZAR PEDIDO
     *
     * @param pedidoRequest
     * @return
     */
    @PutMapping("/pedidos/{id}")
    public PedidoResponse actualizarPedido(@RequestBody PedidoRequest pedidoRequest){
        PedidoResponse pedidoResponse = new PedidoResponse();

        return pedidoResponse;
    }



}
