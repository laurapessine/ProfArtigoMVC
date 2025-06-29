package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Professor;

public interface IProfessorService {
    Professor buscarPorId(Long id);
    List<Professor> buscarTodos();
    void salvar(Professor professor);
    void excluir(Long id);
    boolean professorTemArtigos(Long id);
}