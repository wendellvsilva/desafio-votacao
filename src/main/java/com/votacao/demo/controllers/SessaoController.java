package com.votacao.demo.controllers;

import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.dtos.SessaoDTO;
import com.votacao.demo.service.SessaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping
    public ResponseEntity<Sessao> criarSessao(@RequestBody SessaoDTO sessaoDTO) {
        try {
            Sessao sessao = sessaoService.criarSessao(sessaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(sessao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> obterSessaoPorId(@PathVariable Long id) {
        try {
            Optional<Sessao> sessao = sessaoService.obterSessaoPorId(id);
            return sessao.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
