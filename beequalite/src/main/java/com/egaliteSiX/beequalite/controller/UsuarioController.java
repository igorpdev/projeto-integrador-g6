package com.egaliteSiX.beequalite.controller;

import java.util.List;
import java.util.Optional;

import com.egaliteSiX.beequalite.model.UserLogin;
import com.egaliteSiX.beequalite.model.Usuario;
import com.egaliteSiX.beequalite.repository.UsuarioRepository;
import com.egaliteSiX.beequalite.service.UsuarioService;

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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioService service;

	/*
	 * @GetMapping public ResponseEntity<List<Usuario>> getAll() { return
	 * ResponseEntity.ok(repository.findAll()); }
	 *
	 * @GetMapping("/nome/{nome}") public ResponseEntity<Optional<Usuario>>
	 * getByNome(@PathVariable String nome) { return
	 * ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome)); }
	 */

    //@PostMapping
    //public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
     //   return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    //}

    @GetMapping("/{id}") public ResponseEntity<Usuario> getById(@PathVariable long id) {
      return repository.findById(id).map(resp ->
      ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
        Optional<Usuario> user = service.CadastroUsuario(usuario);
        try {
            return ResponseEntity.ok(user.get());

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user){
    	return service.Login(user).map(resp -> ResponseEntity.ok(resp))
    	.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

	/*
	 * @PutMapping public ResponseEntity<Usuario> put(@RequestBody Usuario usuario)
	 * { return ResponseEntity.ok(repository.save(usuario)); }
	 *
	 * @DeleteMapping("/{id}") public void delete(@PathVariable long id) {
	 * repository.deleteById(id); }
	 */

}
