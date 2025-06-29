package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Artigo;

@SuppressWarnings("unchecked")
public interface IArtigoDAO extends CrudRepository<Artigo, Long> {
    
    // Métodos de CRUD básicos
    Artigo findById(long id);
    List<Artigo> findAll();
    Artigo save(Artigo artigo);
    void deleteById(Long id);

    // Métodos de busca personalizados (opcionais, mas úteis)
    // List<Artigo> findAllByAutores(Professor autor);
}