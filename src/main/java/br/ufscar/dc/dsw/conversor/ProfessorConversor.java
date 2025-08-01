package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IProfessorService;

@Component
public class ProfessorConversor implements Converter<String, Professor> {

    @Autowired
    private IProfessorService professorService;

    @Override
    public Professor convert(@NonNull String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return professorService.buscarPorId(id);
    }
}