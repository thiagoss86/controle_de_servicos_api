package io.github.thiagoss86.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;
}