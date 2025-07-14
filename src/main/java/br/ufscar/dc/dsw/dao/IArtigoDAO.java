package br.ufscar.dc.dsw.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import br.ufscar.dc.dsw.domain.Artigo;

public interface IArtigoDAO extends CrudRepository<Artigo, Long> {
    Artigo findById(long id);

    void deleteById(@NonNull Long id);

    @Query("SELECT a FROM Artigo a LEFT JOIN FETCH a.autores WHERE a.id = :id")
    Artigo findByIdWithAutores(@Param("id") Long id);
}