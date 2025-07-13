package br.ufscar.dc.dsw.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ufscar.dc.dsw.domain.Artigo;
import br.ufscar.dc.dsw.service.spec.IArtigoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ArtigoRestController {
    @Autowired
    private IArtigoService artigoService;

    @GetMapping("/artigos")
    public ResponseEntity<List<Artigo>> listarTodos() {
        List<Artigo> artigos = artigoService.buscarTodos();
        if (artigos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artigos);
    }

    @GetMapping("/artigos/{id}")
    public ResponseEntity<Artigo> buscarPorId(@PathVariable Long id) {
        Artigo artigo = artigoService.buscarPorId(id);
        return (artigo != null) ? ResponseEntity.ok(artigo) : ResponseEntity.notFound().build();
    }

    @PostMapping("/artigos")
    public ResponseEntity<Artigo> criar(@Valid @RequestBody Artigo artigo) {
        artigoService.salvar(artigo);
        return ResponseEntity.status(HttpStatus.CREATED).body(artigo);
    }
    
    @PutMapping("/artigos/{id}")
    public ResponseEntity<Artigo> atualizar(@PathVariable Long id, @Valid @RequestBody Artigo artigo) {
        Artigo existente = artigoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        artigo.setId(id);
        artigoService.salvar(artigo);
        return ResponseEntity.ok(artigo);
    }

    @DeleteMapping("/artigos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Artigo existente = artigoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        artigoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}