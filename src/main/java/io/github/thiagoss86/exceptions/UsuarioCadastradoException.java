package io.github.thiagoss86.exceptions;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException(String login) {
        super("Usuário já cadastrado para o login " + login);
    }
}
