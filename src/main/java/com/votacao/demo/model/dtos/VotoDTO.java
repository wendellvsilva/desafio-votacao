package com.votacao.demo.model.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public record VotoDTO(Long sessaoId,
                      String associadoId,
                      String voto,
                      Long pautaId)
{ }
