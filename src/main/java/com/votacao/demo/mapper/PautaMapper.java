package com.votacao.demo.mapper;

import com.votacao.demo.model.dtos.PautaDTO;
import com.votacao.demo.model.Pauta;
import org.springframework.stereotype.Component;

@Component
public class PautaMapper {

    public Pauta fromDTO(PautaDTO dto) {
        if (dto == null) {
            return null;
        }

        Pauta pauta = new Pauta();
        pauta.setId(dto.getId()); // Use getter
        pauta.setTitulo(dto.getTitulo()); // Use getter
        pauta.setDescricao(dto.getDescricao()); // Use getter

        return pauta;
    }

    public PautaDTO toDTO(Pauta pauta) {
        if (pauta == null) {
            return null;
        }

        return PautaDTO.builder() // Use builder pattern
                .id(pauta.getId())
                .titulo(pauta.getTitulo())
                .descricao(pauta.getDescricao())
                .build();
    }
}
