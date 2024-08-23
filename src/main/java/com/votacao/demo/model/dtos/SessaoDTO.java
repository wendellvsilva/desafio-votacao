package com.votacao.demo.model.dtos;

import java.time.LocalDateTime;

public record SessaoDTO(
        Long id,
        Long pautaId,
        LocalDateTime dataAbertura,
        Integer duracao
) {}
