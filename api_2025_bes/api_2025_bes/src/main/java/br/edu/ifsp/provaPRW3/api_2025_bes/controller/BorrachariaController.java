package br.edu.ifsp.provaPRW3.api_2025_bes.controller;

import br.edu.ifsp.provaPRW3.api_2025_bes.entity.Conserto;
import br.edu.ifsp.provaPRW3.api_2025_bes.models.*;
import br.edu.ifsp.provaPRW3.api_2025_bes.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("conserto")
public class BorrachariaController {

    @Autowired
    private ConsertoRepository consertoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity consertaCarro(@RequestBody @Valid DadosConserto dados, UriComponentsBuilder uriBuilder){
        var conserto = new Conserto(dados);
        consertoRepository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadoConserto(conserto));
    }

    @GetMapping
    public ResponseEntity listarTodosDados(Pageable paginacao){
        var pagina = consertoRepository.findAll(paginacao).map(DadosConsertoListagem::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/resumo")
    public ResponseEntity listarAlgunsDados(){
        var pagina = consertoRepository.findAllByAtivoTrue().map(DadosConsertoResumido::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional = consertoRepository.findById(id);
        if(consertoOptional.isPresent()){
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhadoConserto(conserto));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarDadosResumidos(@RequestBody @Valid DadosAtualizadaoConsertoDTO dados){
        System.out.println("\n\n\n\n\n");
        System.out.println(dados);
        Conserto conserto = consertoRepository.getReferenceById(dados.id());
        conserto.atualizarInfo(dados);
        return ResponseEntity.ok(new DadosDetalhadoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
