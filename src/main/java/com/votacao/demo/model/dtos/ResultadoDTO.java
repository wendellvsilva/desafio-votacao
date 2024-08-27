package com.votacao.demo.model.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public record ResultadoDTO(
        Long pautaId,
        Long votosSim,
        Long votosNao,
        String resultadoFinal
) {}
