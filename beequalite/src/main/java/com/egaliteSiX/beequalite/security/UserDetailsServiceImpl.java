package com.egaliteSiX.beequalite.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.egaliteSiX.beequalite.model.Usuario;
import com.egaliteSiX.beequalite.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findAllByNomeContainingIgnoreCase(nome);
		user.orElseThrow(()-> new UsernameNotFoundException(nome + " not found."));
		return user.map(UserDetailsImpl::new).get();
	}
	
	
		
	


	}

	


