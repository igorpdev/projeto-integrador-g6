package com.egaliteSiX.beequalite.service;

import java.nio.charset.Charset;
import java.util.Optional;

import com.egaliteSiX.beequalite.model.UserLogin;
import com.egaliteSiX.beequalite.model.Usuario;
import com.egaliteSiX.beequalite.repository.UsuarioRepository;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository repository;

    public Optional<Usuario> CadastroUsuario(Usuario usuario) {
    	if (repository.findByEmail(usuario.getEmail()).isPresent() && usuario.getId() == 0) {
    		return null;
    	}

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return Optional.of(repository.save(usuario));
    }

    public Optional <UserLogin> Login(Optional <UserLogin> user){

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder ();
		Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {

			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
    			byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
    			String authHeader = "Basic " + new String(encodedAuth);

    			user.get().setToken(authHeader);
    			user.get().setId(usuario.get().getId());
    			user.get().setNome(usuario.get().getNome());
          user.get().setFoto(usuario.get().getFoto());
          user.get().setTipo(usuario.get().getTipo());

    			return user;
    			}
    		}
    		return null;
    	}

}
