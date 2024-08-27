package com.votacao.demo.model.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public record SessaoDTO(
        Long id,
        Long pautaId,
        LocalDateTime dataAbertura,
        Integer duracao
) {}
