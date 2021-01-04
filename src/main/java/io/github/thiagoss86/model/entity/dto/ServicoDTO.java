package io.github.thiagoss86.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private String descricao;
    private String preco;
    @JsonFormat(locale = "pt_BR", shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String data;
    private Integer idCliente;
}
