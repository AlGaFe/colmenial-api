package com.proyecto.colmenial.controller;


import com.proyecto.colmenial.model.LineaPedidos;
import com.proyecto.colmenial.repository.LineaPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/colmenial")
public class LineaPedidosController {

    @Autowired
    LineaPedidosRepository lineaPedidosRepository;

    @GetMapping("/lineaPedidos")
    public List<LineaPedidos> getAllLineaPedidos() {
        return lineaPedidosRepository.findAll();
    }

    @PostMapping("/lineaPedidos")
    public LineaPedidos createLineaPedidos(@Valid @RequestBody LineaPedidos lineaPedidos) {

        return lineaPedidosRepository.save(lineaPedidos);
    }

    @GetMapping("/lineaPedidos/{id}")
    public LineaPedidos getLineaPedidosById(@PathVariable(value = "id") int id) {
        return lineaPedidosRepository.findOne(id);
    }

    @PutMapping("/lineaPedidos/{id}")
    public LineaPedidos updateLineaPedidos(@PathVariable(value = "id") int id, @Valid @RequestBody LineaPedidos lineaPedidosDetails) {
        LineaPedidos lineaPedidos = lineaPedidosRepository.findOne(id);

        lineaPedidos.setIdProducto(lineaPedidosDetails.getIdProducto());
        lineaPedidos.setCantidad(lineaPedidosDetails.getCantidad());
        lineaPedidos.setNombre(lineaPedidosDetails.getNombre());
        lineaPedidos.setPrecio(lineaPedidosDetails.getPrecio());
        lineaPedidos.setId_pedido(lineaPedidosDetails.getId_pedido());

        LineaPedidos updateLineaPedidos = lineaPedidosRepository.save(lineaPedidos);
        return updateLineaPedidos;
    }

    @DeleteMapping("/lineaPedidos/{id}")
    public ResponseEntity<?> deleteLineaPedidos(@PathVariable(value = "id") int id) {
        LineaPedidos lineaPedidos = lineaPedidosRepository.findOne(id);
        lineaPedidosRepository.delete(lineaPedidos);
        return ResponseEntity.ok().build();
    }
}
