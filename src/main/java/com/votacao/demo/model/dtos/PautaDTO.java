package com.votacao.demo.model.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaDTO {
    private Long id;
    private String titulo;
    private String descricao;
}
