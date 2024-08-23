package com.votacao.demo.mapper;

import com.votacao.demo.model.dtos.VotoDTO;
import com.votacao.demo.model.Voto;
import org.springframework.stereotype.Component;

@Component
public class VotoMapper {
    public Voto fromDTO(VotoDTO dto) {
        return Voto.builder()
                .associadoId(dto.associadoId())
                .voto(dto.voto())
                .build();
    }
}
