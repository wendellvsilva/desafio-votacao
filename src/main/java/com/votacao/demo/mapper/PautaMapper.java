package com.votacao.demo.mapper;


import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.dtos.PautaDTO;
import org.springframework.stereotype.Component;

@Component
public class PautaMapper {
    public Pauta fromDTO(PautaDTO dto) {
        return Pauta.builder()
                .nome(dto.nome())
                .build();
    }
}