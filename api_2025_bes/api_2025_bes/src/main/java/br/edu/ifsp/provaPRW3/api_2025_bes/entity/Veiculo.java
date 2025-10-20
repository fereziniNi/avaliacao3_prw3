package br.edu.ifsp.provaPRW3.api_2025_bes.entity;

import br.edu.ifsp.provaPRW3.api_2025_bes.models.VeiculoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano_carro;
    private String cor;

    public Veiculo(VeiculoDTO dados) {
        this.marca = dados.marca();
        this.ano_carro = dados.ano_carro();
        this.modelo = dados.modelo();
        this.cor = dados.cor();
    }
}
