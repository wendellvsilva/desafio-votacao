package com.votacao.demo.service;

import com.votacao.demo.model.Voto;
import com.votacao.demo.model.dtos.VotoDTO;
import com.votacao.demo.mapper.VotoMapper;
import com.votacao.demo.repository.VotoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VotoService {
    private final VotoRepository votoRepository;
    private final VotoMapper votoMapper;
    private final SessaoService sessaoService;

    public VotoService(VotoRepository votoRepository, VotoMapper votoMapper, SessaoService sessaoService) {
        this.votoRepository = votoRepository;
        this.votoMapper = votoMapper;
        this.sessaoService = sessaoService;
    }

    public Voto submitVoto(Long sessaoId, VotoDTO votoDTO) {
        // Obtém a sessão de votação pelo ID
        var sessao = sessaoService.obterSessaoPorId(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessão de votação não encontrada"));

        // Verifica se a sessão está aberta
        if (sessao.getDataAbertura().plusMinutes(sessao.getDuracao()).isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Sessão de votação fechada ou não existe");
        }

        // Verifica se o voto já foi registrado
        var votoExistente = votoRepository.findBySessaoIdAndAssociadoId(sessaoId, votoDTO.associadoId());
        if (votoExistente.isPresent()) {
            throw new RuntimeException("Associado já votou nesta sessão");
        }

        // Converte DTO para entidade e salva o voto
        Voto voto = votoMapper.fromDTO(votoDTO);
        voto.setSessao(sessao);  // Associa a sessão ao voto
        return votoRepository.save(voto);
    }
}
