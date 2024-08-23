package com.votacao.demo.mapper;

import com.votacao.demo.model.Pauta;
import com.votacao.demo.model.Resultado;
import com.votacao.demo.model.dtos.ResultadoDTO;
import org.springframework.stereotype.Component;

@Component
public class ResultadoMapper {

    public Resultado fromDTO(ResultadoDTO dto) {
        Pauta pauta = new Pauta();
        pauta.setId(dto.pautaId());


        Resultado resultado = new Resultado();
        resultado.setPauta(pauta);
        resultado.setVotosSim(dto.votosSim());
        resultado.setVotosNao(dto.votosNao());
        resultado.setResultadoFinal(dto.resultadoFinal());

        return resultado;
    }
}
