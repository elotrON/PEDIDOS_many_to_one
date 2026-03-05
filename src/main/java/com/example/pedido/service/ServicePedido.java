package com.example.pedido.service;

import com.example.pedido.dto.LineaPedidoRequest;
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
     * OBTENER TODOS LOS PEDIDOS SIN LINEAS
     *
     * @return
     */
    public List<PedidoResponse> getPedidos(){
        List<PedidoResponse> pedidosResponse = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        pedidos = pedidoBBDD.findAll();
        for(Pedido p : pedidos){
            pedidosResponse.add(toResponse(p));
        }
        return pedidosResponse;
    }


    /**
     * OBTENER PEDIDO POR ID CON LINEAS
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
     * AGREGAR LINEA A UN PEDIDO EXISTENTE
     *
     * @param idPedido
     */
    public void agregarLinea(Integer idPedido, LineaPedidoRequest lineaPedidoRequest){
        // buscar el pedido
        Pedido pedido = pedidoBBDD.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido no encontrado" + idPedido));
        if (pedido == null) return;

        // crear una nueva linea
        LineaPedido lineaPedido = new LineaPedido();
        lineaPedido = toPedido(lineaPedidoRequest);
        pedido.addLinea(lineaPedido);


        // guardar la linea en el pedido
        pedidoBBDD.save(pedido);
    }


    /**
     * ELIMINAR LINEA DE PEDIDO
     *
     */
    public void eliminarLinea(Integer idPedido, Integer idLinea){


    }


    /**
     * BORRAR PEDIDO
     *
     * @param idPedido
     */
    public void borrarPedido(Integer idPedido){
        pedidoBBDD.deleteById(idPedido);
    }



    public PedidoResponse actualizarPeido(PedidoRequest pedidoRequest){
        Pedido pedido = new Pedido();

        return toResponse(pedido);

    }


    /**
     * CONVIERTE LineaPedidoRequest -> LineaPedido
     *
     * @param lineaPedidoRequest
     * @return
     */
    private LineaPedido toPedido(LineaPedidoRequest lineaPedidoRequest){
        LineaPedido lineaPedido = new LineaPedido();

        lineaPedido.setArticulo(lineaPedidoRequest.getArticulo());
        lineaPedido.setCantidad(lineaPedidoRequest.getCantidad());
        lineaPedido.setPedido(lineaPedido.getPedido());

        return lineaPedido;
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
