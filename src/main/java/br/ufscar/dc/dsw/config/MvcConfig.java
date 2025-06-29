package br.ufscar.dc.dsw.config;

import br.ufscar.dc.dsw.conversor.ProfessorConversor; // Importe o seu novo conversor
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    ProfessorConversor conversor; // Injete o conversor

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(conversor); // Registre o conversor
    }
}