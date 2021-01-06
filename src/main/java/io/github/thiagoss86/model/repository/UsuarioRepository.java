package io.github.thiagoss86.model.repository;

import io.github.thiagoss86.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
