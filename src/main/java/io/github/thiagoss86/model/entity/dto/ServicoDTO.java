package io.github.thiagoss86.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {

    @NotEmpty(message = "{servico.descricao.obrigatorio}")
    private String descricao;

    @NotEmpty(message = "{servico.preco.obrigatorio}")
    private String preco;

    @NotEmpty(message = "{servico.data.obrigatorio}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String data;

    @NotNull(message = "{servico.cliente.obrigatorio}")
    private Integer idCliente;
}
