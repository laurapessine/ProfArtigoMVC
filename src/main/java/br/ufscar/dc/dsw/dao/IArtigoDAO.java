package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Artigo;

@SuppressWarnings("unchecked")
public interface IArtigoDAO extends CrudRepository<Artigo, Long> {
    Artigo findById(long id);

    List<Artigo> findAll();

    Artigo save(Artigo artigo);

    void deleteById(Long id);

    @Query("SELECT a FROM Artigo a LEFT JOIN FETCH a.autores WHERE a.id = :id")
    Artigo findByIdWithAutores(@Param("id") Long id);
}