package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Conserto;
import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Veiculo;
import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Mecanico;

public record DadosDetalhadoConserto(
        Long id,
        String dt_inicio,
        String dt_fim,
        Veiculo veiculo,
        Mecanico mecanico,
        Boolean ativo
) {
    public DadosDetalhadoConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDt_inicio(),
                conserto.getDt_fim(),
                conserto.getVeiculo(),
                conserto.getMecanico(),
                conserto.isAtivo()
        );
    }
}
