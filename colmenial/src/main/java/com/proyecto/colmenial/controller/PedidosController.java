package com.proyecto.colmenial.controller;

import com.proyecto.colmenial.model.Pedidos;
import com.proyecto.colmenial.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colmenial")
public class PedidosController {

    @Autowired
    PedidosRepository pedidosRepository;

    @GetMapping("/pedidos")
    public List<Pedidos> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    @PostMapping("/pedidos")
    public Pedidos createPedidos(@Valid @RequestBody Pedidos pedidos) {

        return pedidosRepository.save(pedidos);
    }

    @GetMapping("/pedidos/{id}")
    public Pedidos getPedidosById(@PathVariable(value = "id") int id) {
        return pedidosRepository.findOne(id);
    }

    @PutMapping("/pedidos/{id}")
    public Pedidos updatePedidos(@PathVariable(value = "id") int id, @Valid @RequestBody Pedidos pedidosDetails) {
        Pedidos pedido = pedidosRepository.findOne(id);

        pedido.setCliente(pedidosDetails.getCliente());
        pedido.setFecha(pedidosDetails.getFecha());

        Pedidos updatePedidos = pedidosRepository.save(pedido);
        return updatePedidos;
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<?> deletePedidos(@PathVariable(value = "id") int id) {
        Pedidos pedidos = pedidosRepository.findOne(id);
        pedidosRepository.delete(pedidos);
        return ResponseEntity.ok().build();
    }
}
