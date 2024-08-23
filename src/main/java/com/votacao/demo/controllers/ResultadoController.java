package com.votacao.demo.controllers;

import com.votacao.demo.model.dtos.ResultadoDTO;
import com.votacao.demo.model.Resultado;
import com.votacao.demo.mapper.ResultadoMapper;
import com.votacao.demo.repository.ResultadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    private final ResultadoRepository resultadoRepository;
    private final ResultadoMapper resultadoMapper;

    public ResultadoController(ResultadoRepository resultadoRepository, ResultadoMapper resultadoMapper) {
        this.resultadoRepository = resultadoRepository;
        this.resultadoMapper = resultadoMapper;
    }

    @PostMapping
    public ResponseEntity<Resultado> calculateResultado(@RequestBody ResultadoDTO resultadoDTO) {
        Resultado resultado = resultadoMapper.fromDTO(resultadoDTO);
        Resultado savedResultado = resultadoRepository.save(resultado);
        return new ResponseEntity<>(savedResultado, HttpStatus.CREATED);
    }
}
