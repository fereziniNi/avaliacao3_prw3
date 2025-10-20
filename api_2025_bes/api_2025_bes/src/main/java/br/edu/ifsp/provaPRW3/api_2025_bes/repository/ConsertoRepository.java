package br.edu.ifsp.provaPRW3.api_2025_bes.repository;

import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Conserto;
import br.edu.ifsp.provaPRW3.api_2025_bes.models.DadosConsertoResumido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    Page<Conserto> findAllByAtivoTrue();
}
