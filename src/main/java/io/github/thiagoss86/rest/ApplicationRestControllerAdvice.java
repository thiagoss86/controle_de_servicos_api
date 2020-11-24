package io.github.thiagoss86.rest;

import io.github.thiagoss86.exceptions.ApiErrors;
import jdk.Exported;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> mensagens = bindingResult.getAllErrors()
                                            .stream()
                                            .map( objectError -> objectError.getDefaultMessage())
                                            .collect(Collectors.toList());

        return new ApiErrors(mensagens);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {
        String menssagemErro = ex.getMessage();
        HttpStatus codigoStatus = HttpStatus.NOT_FOUND;
        ApiErrors apiErrors = new ApiErrors(menssagemErro);

        return new ResponseEntity(apiErrors, codigoStatus);
    }
}
