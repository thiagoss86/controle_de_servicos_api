package io.github.thiagoss86.rest;

import io.github.thiagoss86.model.entity.Usuario;
import io.github.thiagoss86.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioRepository repository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
         repository.save(usuario);
    }
}
