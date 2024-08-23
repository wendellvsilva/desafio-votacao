package com.votacao.demo.repository;

import com.votacao.demo.model.Sessao;
import com.votacao.demo.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    Optional<Voto> findBySessaoIdAndAssociadoId(Long sessaoId, String associadoId);
    List<Voto> findBySessaoId(Long sessaoId);
}

