package br.ufscar.dc.dsw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import br.ufscar.dc.dsw.domain.Professor;

public interface IProfessorDAO extends CrudRepository<Professor, Long> {
    Professor findById(long id);

    void deleteById(@NonNull Long id);
}