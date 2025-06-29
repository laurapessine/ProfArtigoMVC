package br.ufscar.dc.dsw.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Professor professor) {
        return "professor/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("professores", professorService.buscarTodos());
        return "professor/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Professor professor, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "professor/cadastro";
        }
        professorService.salvar(professor);
        attr.addFlashAttribute("sucess", "Professor inserido com sucesso.");
        return "redirect:/professores/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("professor", professorService.buscarPorId(id));
        return "professor/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Professor professor, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "professor/cadastro";
        }
        professorService.salvar(professor);
        attr.addFlashAttribute("sucess", "Professor editado com sucesso.");
        return "redirect:/professores/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (professorService.professorTemArtigos(id)) {
            attr.addFlashAttribute("fail", "Professor não excluído. Possui artigo(s) vinculado(s).");
        } else {
            professorService.excluir(id);
            attr.addFlashAttribute("sucess", "Professor excluído com sucesso.");
        }
        return "redirect:/professores/listar";
    }
}