package io.github.thiagoss86.rest;

import io.github.thiagoss86.model.entity.Servico;
import io.github.thiagoss86.model.entity.dto.ServicoDTO;
import io.github.thiagoss86.model.repository.ClienteRepository;
import io.github.thiagoss86.model.repository.ServicoRepository;
import io.github.thiagoss86.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServicoController {

    private final ClienteRepository clienteRepository;
    private final ServicoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico salvar(@RequestBody @Valid ServicoDTO dto) {
        Servico servico = new Servico();

        servico.setDescricao(dto.getDescricao());
        servico.setData(LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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
