package io.github.thiagoss86.rest;

import io.github.thiagoss86.model.entity.Servico;
import io.github.thiagoss86.model.entity.dto.ServicoDTO;
import io.github.thiagoss86.model.repository.ClienteRepository;
import io.github.thiagoss86.model.repository.ServicoRepository;
import io.github.thiagoss86.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class ServicoController {

    private final ClienteRepository clienteRepository;
    private final ServicoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico salvar(@RequestBody ServicoDTO dto) {
        Servico servico = new Servico();

        servico.setDescricao(dto.getDescricao());
        servico.setData(LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        servico.setCliente(
                clienteRepository.findById(dto.getIdCliente()).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")));

        servico.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return repository.save(servico);

    }

    @GetMapping
    public List<Servico> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
}
