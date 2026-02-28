package com.example.pedido.service;

import com.example.pedido.entity.EstadoPedido;
import com.example.pedido.entity.Pedido;
import com.example.pedido.dto.PedidoRequest;
import com.example.pedido.dto.PedidoResponse;
import com.example.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ServicePedido {

    private final PedidoRepository pedidoBBDD;

    public ServicePedido(PedidoRepository pedidoBBDD) {
        this.pedidoBBDD = pedidoBBDD;
    }

    /**
     * CREAR PEDIDO
     *
     * @param pedidoRequest
     * @return
     */
    public PedidoResponse crearPedido (PedidoRequest pedidoRequest){
        Pedido pedido = new Pedido();

        pedido.setAnotacion(pedidoRequest.getAnotacion());
        pedido.setEstadoPedido(EstadoPedido.PENDIENTE);
        pedido.setTimestamp( LocalDateTime.now() );
        pedido.setCliente( pedidoRequest.getCliente() );

        return toResponse(pedidoBBDD.save(pedido));
    }

    /**
     * BORRAR PEDIDO
     *
     * @param idPedido
     */
    public void borrarPedido(Integer idPedido){
        pedidoBBDD.deleteById(idPedido);
    }

    /**
     * AGREGAR LINEA A PEDIDO
     *
     * @param idPedido
     */
    public void agregarLinea(Integer idPedido){

    }

    /**
     * ELIMINAR LINEA DE PEDIDO
     *
     */
    public void eliminarLinea(){


    }



    /**
     * OBTENER PEDIDO POR ID
     *
     * @param id
     * @return
     */
    public PedidoResponse getAvisoId(int id){

        //todo
        return null;
    }


    /**
     * CONVIERTE Pedido -> PedidoResponse
     *
     * @param pedido
     * @return
     */
    private PedidoResponse toResponse(Pedido pedido){
        PedidoResponse response = new PedidoResponse();

        response.setAnotacion(pedido.getAnotacion());
        response.setEstadoPedido(pedido.getEstadoPedido());
        response.setCliente(pedido.getCliente());
        response.setTimestamp( pedido.getTimestamp());

        return response;
    }


}
