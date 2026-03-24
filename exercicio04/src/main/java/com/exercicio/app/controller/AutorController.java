package com.exercicio.app.controller;
import com.exercicio.app.entity.Autor;
import com.exercicio.app.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isEmpty()) return ResponseEntity.notFound().build();
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
