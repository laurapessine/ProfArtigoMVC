package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IProfessorService;

@Component
public class ProfessorConversor implements Converter<String, Professor> {

    @Autowired
    private IProfessorService professorService;

    @Override
    public Professor convert(String text) {
        // Se o texto estiver vazio ou nulo, retorna nulo
        if (text.isEmpty() || text == null) {
            return null;
        }
        
        // Converte o ID de String para Long
        Long id = Long.valueOf(text);
        
        // Busca o professor no banco de dados pelo ID
        return professorService.buscarPorId(id);
    }
}