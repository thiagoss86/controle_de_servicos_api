package io.github.thiagoss86.rest;

import io.github.thiagoss86.exceptions.UsuarioCadastradoException;
import io.github.thiagoss86.model.entity.Usuario;
import io.github.thiagoss86.model.repository.UsuarioRepository;
import io.github.thiagoss86.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario) {
        try{
            service.salvar(usuario);
        }catch (UsuarioCadastradoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }
}
