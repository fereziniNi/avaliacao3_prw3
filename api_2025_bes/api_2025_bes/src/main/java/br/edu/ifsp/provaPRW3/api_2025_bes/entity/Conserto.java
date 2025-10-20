package br.edu.ifsp.provaPRW3.api_2025_bes.entity;

import br.edu.ifsp.provaPRW3.api_2025_bes.models.DadosAtualizadaoConsertoDTO;
import br.edu.ifsp.provaPRW3.api_2025_bes.models.DadosConserto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.StyledEditorKit;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dt_inicio;
    private String dt_fim;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;

    private Boolean ativo;


    public Conserto(DadosConserto dados) {
        this.dt_inicio = dados.dt_inicio();
        this.dt_fim = dados.dt_fim();
        this.veiculo = new Veiculo(dados.veiculoDTO());
        this.mecanico = new Mecanico(dados.mecanicoResp());
        this.ativo = true;
    }

    public Boolean isAtivo(){
        return ativo;
    }

    public void excluir(){
        this.ativo = false;
    }

    public void atualizarInfo(DadosAtualizadaoConsertoDTO dados){
        if (dados.dt_fim() != null){
            this.dt_fim = dados.dt_fim();
        }
        if(dados.mecanicoDTO() != null){
            this.mecanico.atualizarInfo(dados.mecanicoDTO());
        }
    }
}
