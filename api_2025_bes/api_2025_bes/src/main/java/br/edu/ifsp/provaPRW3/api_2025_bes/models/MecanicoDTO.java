package br.edu.ifsp.provaPRW3.api_2025_bes.models;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,
        int anosExp) {
}
