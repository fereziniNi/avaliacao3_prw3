package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Conserto;

public record DadosConsertoResumido(
        Long id,
        String dt_inicio,
        String dt_fim,
        String mecanicoNome,
        String veiculoMarca,
        String veiculoModelo,
        Boolean ativo
) {
    public DadosConsertoResumido(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDt_inicio(),
                conserto.getDt_fim(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo(),
                conserto.getAtivo()
        );
    }
}