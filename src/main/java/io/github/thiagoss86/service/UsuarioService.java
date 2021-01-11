package io.github.thiagoss86.service;

import io.github.thiagoss86.exceptions.UsuarioCadastradoException;
import io.github.thiagoss86.model.entity.Usuario;
import io.github.thiagoss86.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService  implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository
                            .findByUsername(username)
                            .orElseThrow(() -> new UsernameNotFoundException("Login inexistente"));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }

    public Usuario salvar(Usuario usuario) {
        boolean existe = repository.existsByUsername(usuario.getUsername());

        if(existe)
            new UsuarioCadastradoException(usuario.getUsername());

        return repository.save(usuario);
    }
}
