package com.votacao.demo.mapper;


import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.Voto;
import com.votacao.demo.model.dtos.VotoDTO;
import org.springframework.stereotype.Component;

@Component
public class VotoMapper {
    public Voto fromDTO(VotoDTO dto) {
        return Voto.builder()
                .pauta(Pauta.builder().id(dto.pautaId()).build())
                .associadoId(dto.associadoId())
                .voto(dto.voto())
                .build();
    }
}
