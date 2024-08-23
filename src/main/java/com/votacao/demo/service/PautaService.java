package com.votacao.demo.service;

import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.dtos.PautaDTO;
import com.votacao.demo.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    public PautaDTO criarPauta(String nome) {
        Pauta pauta = new Pauta();
        pauta.setNome(nome);
        pauta = pautaRepository.save(pauta);
        return VotacaoMapper.INSTANCE.toPautaDTO(pauta);
    }
}