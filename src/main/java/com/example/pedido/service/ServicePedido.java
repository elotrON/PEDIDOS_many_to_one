package com.example.pedido.service;

import com.example.pedido.entity.Pedido;
import com.example.pedido.model.PedidoRequest;
import com.example.pedido.model.PedidoResponse;
import org.springframework.stereotype.Service;


@Service
public class ServicePedido {

    /**
     * CREAR UN AVISO
     *
     * @param pedidoRequest
     * @return
     */
    public PedidoResponse crearAviso (PedidoRequest pedidoRequest){



        return toResponse(pedidoRequest);
    }

    /**
     * OBTENER AVISO POR ID
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



        return response;
    }

    /**
     * CONVIERTE PedidoRequest -> PedidoResponse
     *
     * @param pedidoRequest
     * @return
     */
    private PedidoResponse toResponse(PedidoRequest pedidoRequest){
        PedidoResponse response = new PedidoResponse();


        return response;
    }

}
