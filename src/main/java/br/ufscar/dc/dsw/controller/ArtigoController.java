package br.ufscar.dc.dsw.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Artigo;
import br.ufscar.dc.dsw.domain.Professor;
import br.ufscar.dc.dsw.service.spec.IArtigoService;
import br.ufscar.dc.dsw.service.spec.IProfessorService;

@Controller
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private IArtigoService artigoService;

    @Autowired
    private IProfessorService professorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Artigo artigo) {
        return "artigo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("artigos", artigoService.buscarTodos());
        return "artigo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Artigo artigo, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "artigo/cadastro";
        }
        artigoService.salvar(artigo);
        attr.addFlashAttribute("sucess", "Artigo inserido com sucesso.");
        return "redirect:/artigos/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("artigo", artigoService.buscarPorId(id));
        return "artigo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Artigo artigo, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "artigo/cadastro";
        }
        artigoService.salvar(artigo);
        attr.addFlashAttribute("sucess", "Artigo editado com sucesso.");
        return "redirect:/artigos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        artigoService.excluir(id);
        attr.addFlashAttribute("sucess", "Artigo excluído com sucesso.");
        return "redirect:/artigos/listar";
    }

    @ModelAttribute("professores")
    public List<Professor> listaProfessores() {
        return professorService.buscarTodos();
    }
}