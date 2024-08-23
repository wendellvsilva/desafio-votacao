package com.votacao.demo.model.dtos;

import java.time.LocalDateTime;

public record SessaoDTO(Long pautaId, LocalDateTime dataEncerramento) {}
