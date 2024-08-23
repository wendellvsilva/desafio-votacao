package com.votacao.demo.service;

import com.votacao.demo.model.dtos.PautaDTO;
import com.votacao.demo.mapper.PautaMapper;
import com.votacao.demo.model.Pauta;
import com.votacao.demo.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private PautaMapper pautaMapper;

    public PautaDTO createPauta(PautaDTO pautaDTO) {
        Pauta pauta = pautaMapper.fromDTO(pautaDTO);
        pauta = pautaRepository.save(pauta);
        return pautaMapper.toDTO(pauta);
    }

    public Optional<PautaDTO> getPautaById(Long id) {
        return pautaRepository.findById(id)
                .map(pautaMapper::toDTO);
    }

    public List<PautaDTO> getAllPautas() {
        return pautaRepository.findAll()
                .stream()
                .map(pautaMapper::toDTO)
                .toList();
    }
}
