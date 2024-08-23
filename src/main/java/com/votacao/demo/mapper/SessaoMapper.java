package com.votacao.demo.mapper;

import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.dtos.SessaoDTO;
import org.springframework.stereotype.Component;

@Component
public class SessaoMapper {

    public SessaoDTO toDTO(Sessao sessao) {
        if (sessao == null) {
            return null;
        }
        return new SessaoDTO(
                sessao.getId(),
                sessao.getPauta() != null ? sessao.getPauta().getId() : null,
                sessao.getDataAbertura(),
                sessao.getDuracao()
        );
    }

    public Sessao fromDTO(SessaoDTO sessaoDTO, Pauta pauta) {
        if (sessaoDTO == null) {
            return null;
        }
        return Sessao.builder()
                .id(sessaoDTO.id())
                .pauta(pauta)  // Defina a pauta correta ao criar uma Sessao
                .dataAbertura(sessaoDTO.dataAbertura())
                .duracao(sessaoDTO.duracao())
                .build();
    }
}
