package com.votacao.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private Integer duracao;

    @PostLoad
    private void setDataEncerramento() {
        if (dataAbertura != null && duracao != null) {
            this.dataEncerramento = dataAbertura.plusMinutes(duracao);
        }
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }
}
