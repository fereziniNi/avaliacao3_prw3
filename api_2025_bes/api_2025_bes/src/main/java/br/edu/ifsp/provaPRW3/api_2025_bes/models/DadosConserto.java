package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @NotNull
        @Pattern(regexp="^\\d{2}/\\d{2}/\\d{4}$")
        String dt_inicio,

        @NotBlank
        @Pattern(regexp="^\\d{2}/\\d{2}/\\d{4}$")
        String dt_fim,

        MecanicoDTO mecanicoResp,

        VeiculoDTO veiculoDTO,
        Boolean ativo
        ) {
}
