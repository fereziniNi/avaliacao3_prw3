package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @Pattern(regexp = "^\\d{4}$")
        String ano_carro,

        String cor) {
}
