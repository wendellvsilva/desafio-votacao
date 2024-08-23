package com.votacao.demo.controllers;

import com.votacao.demo.model.dtos.VotoDTO;
import com.votacao.demo.model.Voto;
import com.votacao.demo.service.VotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class VotoController {

    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping("/{sessaoId}/votos")
    public ResponseEntity<Voto> registrarVoto(@PathVariable Long sessaoId, @RequestBody VotoDTO votoDTO) {
        try {
            Voto voto = votoService.submitVoto(sessaoId, votoDTO);
            if (voto != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(voto);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

//    @GetMapping("/{sessaoId}/resultados")
//    public ResponseEntity<?> obterResultados(@PathVariable Long sessaoId) {
//        try {
//            // Implementar o método no serviço para obter os resultados
//            // Substitua o código abaixo com a lógica real para obter resultados
//            Object resultados = votoService.obterResultados(sessaoId);
//            return ResponseEntity.ok(resultados);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        }

}
