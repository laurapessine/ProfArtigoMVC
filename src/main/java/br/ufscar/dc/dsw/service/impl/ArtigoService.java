package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IArtigoDAO;
import br.ufscar.dc.dsw.domain.Artigo;
import br.ufscar.dc.dsw.service.spec.IArtigoService;

@Service
@Transactional(readOnly = false)
public class ArtigoService implements IArtigoService {

    @Autowired
    IArtigoDAO dao;

    @Override
    public Artigo salvar(Artigo artigo) {
        return dao.save(artigo);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Artigo buscarPorId(Long id) {
        return dao.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Artigo> buscarTodos() {
        return dao.findAll();
    }
}