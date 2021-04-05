package com.egaliteSiX.beequalite.controller;

import java.util.List;

import com.egaliteSiX.beequalite.model.Postagem;
import com.egaliteSiX.beequalite.repository.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/postagem")
public class PostagemController {
    
    @Autowired
    public PostagemRepository repository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Postagem> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @GetMapping("/texto/{texto}")
    public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto) {
        return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
    }

    @GetMapping("/data/{data}")
    public ResponseEntity <List<Postagem>> getByData(@PathVariable String data) {
        return ResponseEntity.ok(repository.findAllByDataContaining(data));
    }

    @PostMapping
    public ResponseEntity <Postagem> post(@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @PutMapping
    public ResponseEntity <Postagem> put(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(repository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

}
