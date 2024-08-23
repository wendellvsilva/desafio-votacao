package com.votacao.demo.model.dtos;

public record VotoDTO(Long sessaoId, String associadoId, String voto,
                      Long pautaId) { }
