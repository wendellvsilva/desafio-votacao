package com.votacao.demo.service;

import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.dtos.SessaoDTO;
import com.votacao.demo.repository.PautaRepository;
import com.votacao.demo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    public SessaoDTO abrirSessao(Long pautaId, LocalDateTime dataFim) {
        Pauta pauta = pautaRepository.findById(pautaId).orElseThrow();
        Sessao sessao = new Sessao();
        sessao.setPauta(pauta);
        sessao.setDataInicio(LocalDateTime.now());
        sessao.setDataFim(dataFim != null ? dataFim : LocalDateTime.now().plusMinutes(1));
        sessao = sessaoRepository.save(sessao);
        return VotacaoMapper.INSTANCE.toSessaoDTO(sessao);
    }
}