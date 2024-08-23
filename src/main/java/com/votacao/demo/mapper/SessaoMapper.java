package com.votacao.demo.mapper;

import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.dtos.SessaoDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SessaoMapper {
    public Sessao fromDTO(SessaoDTO dto) {
        return Sessao.builder()
                .dataEncerramento(dto.dataEncerramento())
                .dataAbertura(LocalDateTime.now())
                .build();
    }
}
