package com.votacao.demo.mapper;

import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.Resultado;
import com.votacao.demo.model.dtos.ResultadoDTO;
import org.springframework.stereotype.Component;

@Component
public class ResultadoMapper {
    public Resultado fromDTO(ResultadoDTO dto) {
        return Resultado.builder()
                .pauta(Pauta.builder().id(dto.pautaId()).build())
                .votosSim(dto.votosSim())
                .votosNao(dto.votosNao())
                .resultadoFinal(dto.resultadoFinal())
                .build();
    }
}
