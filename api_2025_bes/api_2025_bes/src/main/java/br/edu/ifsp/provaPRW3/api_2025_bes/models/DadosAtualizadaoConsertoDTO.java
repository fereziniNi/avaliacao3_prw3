package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizadaoConsertoDTO(
        @NotNull
        Long id,
        String dt_fim,
        MecanicoDTO mecanicoDTO
) {
}
