package com.votacao.demo.repository;

import com.votacao.demo.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {}
