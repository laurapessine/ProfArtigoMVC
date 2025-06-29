package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Professor;

@SuppressWarnings("unchecked")
public interface IProfessorDAO extends CrudRepository<Professor, Long> {
    
    Professor findById(long id);

    List<Professor> findAll();

    Professor save(Professor professor);

    void deleteById(Long id);

    // Métodos de busca personalizados (opcionais, mas úteis)

    // Professor findByEmail(String email);
    
    // Professor findByLattes(String lattes);
}