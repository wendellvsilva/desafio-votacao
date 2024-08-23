package com.votacao.demo.service;

import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.Voto;
import com.votacao.demo.model.dtos.VotoDTO;
import com.votacao.demo.repository.SessaoRepository;
import com.votacao.demo.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    public VotoDTO registrarVoto(Long sessaoId, String associadoId, boolean voto) {
        if (votoRepository.existsByAssociadoIdAndSessaoId(associadoId, sessaoId)) {
            throw new IllegalArgumentException("Associado já votou nesta sessão.");
        }

        Sessao sessao = sessaoRepository.findById(sessaoId).orElseThrow();
        Voto novoVoto = new Voto();
        novoVoto.setSessao(sessao);
        novoVoto.setAssociadoId(associadoId);
        novoVoto.setVoto(voto);
        novoVoto = votoRepository.save(novoVoto);
        return VotacaoMapper.INSTANCE.toVotoDTO(novoVoto);
    }

    public long contarVotos(Long sessaoId, boolean voto) {
        Sessao sessao = sessaoRepository.findById(sessaoId).orElseThrow();
        return sessao.getVotos().stream().filter(v -> v.isVoto() == voto).count();
    }
}