package br.ufscar.dc.dsw.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IArtigoDAO;
import br.ufscar.dc.dsw.dao.IProfessorDAO;
import br.ufscar.dc.dsw.domain.Artigo;
import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IArtigoService;

@Service
@Transactional(readOnly = false)
public class ArtigoService implements IArtigoService {
    @Autowired
    IArtigoDAO dao;

    @Autowired
    IProfessorDAO professorDAO;

    @Override
    public Artigo salvar(Artigo artigo) {
        List<Professor> autoresCompletos = new ArrayList<>();
        if (artigo.getAutores() != null) {
            for (Professor autor : artigo.getAutores()) {
                Professor autorCompleto = professorDAO.findById(autor.getId()).get();
                autoresCompletos.add(autorCompleto);
            }
        }
        artigo.setAutores(autoresCompletos);
        return dao.save(artigo);
    }

    @Override
    public Artigo criar(Artigo artigo) {
        Artigo artigoSalvo = dao.save(artigo);
        return dao.findByIdWithAutores(artigoSalvo.getId());
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Artigo buscarPorId(Long id) {
        return dao.findByIdWithAutores(id);
    }

    @Transactional(readOnly = true)
    public List<Artigo> buscarTodos() {
        return new ArrayList<Artigo>((dao.findAll() instanceof List) ? (List<Artigo>) dao.findAll() : new ArrayList<Artigo>());
    }
}