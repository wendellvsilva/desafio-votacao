package com.votacao.demo.service;

import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.dtos.SessaoDTO;
import com.votacao.demo.repository.SessaoRepository;
import com.votacao.demo.repository.PautaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessaoService {
    private final SessaoRepository sessaoRepository;
    private final PautaRepository pautaRepository;

    public SessaoService(SessaoRepository sessaoRepository, PautaRepository pautaRepository) {
        this.sessaoRepository = sessaoRepository;
        this.pautaRepository = pautaRepository;
    }

    public Sessao criarSessao(SessaoDTO sessaoDTO) {
        if (sessaoDTO.duracao() == null) {
            throw new IllegalArgumentException("A duração da sessão não pode ser nula.");
        }

        Pauta pauta = pautaRepository.findById(sessaoDTO.pautaId())
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        Sessao sessao = new Sessao();
        sessao.setPauta(pauta);
        sessao.setDataAbertura(LocalDateTime.now());
        sessao.setDuracao(sessaoDTO.duracao());
        sessao.setDataEncerramento(LocalDateTime.now().plusMinutes(sessaoDTO.duracao()));

        return sessaoRepository.save(sessao);
    }

    public Optional<Sessao> obterSessaoPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        return sessaoRepository.findById(id);
    }
}
