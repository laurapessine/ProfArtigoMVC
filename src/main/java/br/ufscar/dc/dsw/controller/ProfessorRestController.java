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
import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IProfessorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api") // Prefixo para todos os endpoints da API
public class ProfessorRestController {
    @Autowired
    private IProfessorService professorService;

    // GET /api/professores - Retorna todos os professores
    @GetMapping("/professores")
    public ResponseEntity<List<Professor>> listarTodos() {
        List<Professor> professores = professorService.buscarTodos();
        if (professores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professores);
    }

    // GET /api/professores/{id} - Retorna um professor por ID
    @GetMapping("/professores/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable("id") Long id) {
        Professor professor = professorService.buscarPorId(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }

    // POST /api/professores - Cria um novo professor
    @PostMapping("/professores")
    public ResponseEntity<Professor> criar(@Valid @RequestBody Professor professor) {
        professorService.salvar(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    // PUT /api/professores/{id} - Atualiza um professor existente
    @PutMapping("/professores/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable("id") Long id, @Valid @RequestBody Professor professor) {
        Professor professorExistente = professorService.buscarPorId(id);
        if (professorExistente == null) {
            return ResponseEntity.notFound().build();
        }
        professor.setId(id);
        professorService.salvar(professor);
        return ResponseEntity.ok(professor);
    }

    // DELETE /api/professores/{id} - Remove um professor
    @DeleteMapping("/professores/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
        Professor professor = professorService.buscarPorId(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        if (professorService.professorTemArtigos(id)) {
            // Retorna 422 Unprocessable Entity
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        professorService.excluir(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}