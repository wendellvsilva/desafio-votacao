package com.votacao.demo.service;

import com.votacao.demo.model.Voto;
import com.votacao.demo.model.Sessao;
import com.votacao.demo.repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ResultadoService {
    private final VotoRepository votoRepository;
    private final SessaoService sessaoService;

    public ResultadoService(VotoRepository votoRepository, SessaoService sessaoService) {
        this.votoRepository = votoRepository;
        this.sessaoService = sessaoService;
    }

    public Map<String, Long> getResultado(Long sessaoId) {

        Optional<Sessao> sessaoOptional = sessaoService.obterSessaoPorId(sessaoId);


        Sessao sessao = sessaoOptional
                .orElseThrow(() -> new RuntimeException("Sessão de votação não encontrada"));

        var votos = votoRepository.findBySessaoId(sessaoId);

        // Conta os votos
        Map<String, Long> resultado = new HashMap<>();
        resultado.put("Sim", votos.stream().filter(voto -> "Sim".equals(voto.getVoto())).count());
        resultado.put("Não", votos.stream().filter(voto -> "Não".equals(voto.getVoto())).count());

        return resultado;
    }
}
