package Projeto.example.HackaGabaritos.Controller;

import Projeto.example.HackaGabaritos.Model.Disciplina;
import Projeto.example.HackaGabaritos.Service.DisciplinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("disciplinas", service.listar());
        return "disciplina/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Disciplina disciplina) {
        service.salvar(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Disciplina d = service.buscarPorId(id).orElseThrow();
        model.addAttribute("disciplina", d);
        return "disciplina/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/disciplinas";
    }
}


