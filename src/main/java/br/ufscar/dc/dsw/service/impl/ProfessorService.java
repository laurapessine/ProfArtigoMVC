package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IProfessorDAO;
import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IProfessorService;

@Service
@Transactional(readOnly = false)
public class ProfessorService implements IProfessorService {
    @Autowired
    IProfessorDAO dao;

    public void salvar(Professor professor) {
        dao.save(professor);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Professor buscarPorId(Long id) {
        return dao.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Professor> buscarTodos() {
        Iterable<Professor> iterable = dao.findAll();
        List<Professor> list = new java.util.ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Transactional(readOnly = true)
    public boolean professorTemArtigos(Long id) {
        return !this.buscarPorId(id).getArtigos().isEmpty();
    }
}