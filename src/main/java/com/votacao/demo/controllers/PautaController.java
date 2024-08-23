package com.votacao.demo.controllers;

import com.votacao.demo.model.dtos.PautaDTO;
import com.votacao.demo.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<PautaDTO> createPauta(@RequestBody PautaDTO pautaDTO) {
        PautaDTO createdPauta = pautaService.createPauta(pautaDTO);
        return new ResponseEntity<>(createdPauta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaDTO> getPautaById(@PathVariable Long id) {
        Optional<PautaDTO> pauta = pautaService.getPautaById(id);
        return pauta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<PautaDTO>> getAllPautas() {
        List<PautaDTO> pautas = pautaService.getAllPautas();
        return ResponseEntity.ok(pautas);
    }
}