package com.example.pedido.service;

import com.example.pedido.dto.LineaPedidoResponse;
import com.example.pedido.entity.EstadoPedido;
import com.example.pedido.entity.LineaPedido;
import com.example.pedido.entity.Pedido;
import com.example.pedido.dto.PedidoRequest;
import com.example.pedido.dto.PedidoResponse;
import com.example.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
        pedido.setFecha( LocalDateTime.now() );
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
    public PedidoResponse getPedidoId(int id) {
        Pedido pedido = pedidoBBDD.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + id));

        PedidoResponse response = toResponse(pedido);

        List<LineaPedidoResponse> lineas = new ArrayList<>();
        
        for (LineaPedido lp : pedido.getLineas()) {
            LineaPedidoResponse r = new LineaPedidoResponse();
            r.setId(lp.getId());
            r.setArticulo(lp.getArticulo());
            r.setCantidad(lp.getCantidad());
            lineas.add(r);
        }
        response.setLineas(lineas);

        return response;
    }


    /**
     * CONVIERTE Pedido -> PedidoResponse
     *
     * @param pedido
     * @return
     */
    private PedidoResponse toResponse(Pedido pedido){
        PedidoResponse response = new PedidoResponse();

        response.setId(pedido.getId());
        response.setAnotacion(pedido.getAnotacion());
        response.setEstadoPedido(pedido.getEstadoPedido());
        response.setCliente(pedido.getCliente());
        response.setTimestamp( pedido.getFecha());

        return response;
    }


}
