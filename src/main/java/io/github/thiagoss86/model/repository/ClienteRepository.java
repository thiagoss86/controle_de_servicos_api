package io.github.thiagoss86.model.repository;

import io.github.thiagoss86.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
