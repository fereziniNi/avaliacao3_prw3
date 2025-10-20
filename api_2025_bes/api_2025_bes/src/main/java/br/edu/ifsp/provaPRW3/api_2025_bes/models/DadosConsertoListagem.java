package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Conserto;
import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Mecanico;
import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Veiculo;

public record DadosConsertoListagem(
        Long id,
        String dt_inicio,
        String dt_fim,
        Mecanico mecanico,
        Veiculo veiculo) {

    public DadosConsertoListagem(Conserto conserto){
        this(conserto.getId(), conserto.getDt_inicio(), conserto.getDt_fim(), conserto.getMecanico(), conserto.getVeiculo());
    }

}
