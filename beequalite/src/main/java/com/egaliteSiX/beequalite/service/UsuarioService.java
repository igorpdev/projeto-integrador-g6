package com.egaliteSiX.beequalite.service;

import java.util.Optional;

import com.egaliteSiX.beequalite.model.Usuario;
import com.egaliteSiX.beequalite.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository repository;
    
    public Optional<Usuario> CadastroUsuario(Usuario email) {
        if (repository.findAllByEmailContainingIgnoreCase(email.getEmail()).isPresent()) {
            return null;
        }
        return Optional.of(repository.save(email));
    }
}
