package io.github.thiagoss86.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotEmpty(message = "{usuario.campo.login.obrigatorio}")
    private String username;

    @Column
    @NotEmpty(message =  "usuario.campo.senha.obrigatorio")
    private String password;

}
