package br.edu.ifsp.provaPRW3.api_2025_bes.entity;

import br.edu.ifsp.provaPRW3.api_2025_bes.models.MecanicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosExp;

    public Mecanico(MecanicoDTO dados) {
        this.nome = dados.nome();
        this.anosExp = dados.anosExp();
    }

    public void atualizarInfo(MecanicoDTO dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        this.anosExp = dados.anosExp();
    }
}
