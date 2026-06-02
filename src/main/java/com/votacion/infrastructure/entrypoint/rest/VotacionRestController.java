package com.votacion.infrastructure.entrypoint.rest;

import com.votacion.application.port.IVotacionPort;
import com.votacion.domain.model.Votacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/votacion")
public class VotacionRestController {

    @Autowired
    @Qualifier("votacionRepositoryPort")
    private IVotacionPort votacionPort;

    @GetMapping
    public ResponseEntity<List<Votacion>> listar() {
        return ResponseEntity.ok(votacionPort.listarVotaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Votacion> buscar(@PathVariable Long id) {
        Votacion votacion = votacionPort.buscarPorId(id);
        if (votacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(votacion);
    }

    @PostMapping
    public ResponseEntity<Votacion> crear(@RequestBody Votacion votacion) {
        Votacion nueva = votacionPort.guardar(votacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Votacion> actualizar(@PathVariable Long id, @RequestBody Votacion votacion) {
        Votacion actualizada = votacionPort.actualizar(id, votacion);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        votacionPort.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}