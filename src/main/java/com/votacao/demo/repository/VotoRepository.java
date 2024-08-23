package com.votacao.demo.repository;

import com.votacao.demo.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {}
