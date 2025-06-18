package Projeto.example.HackaGabaritos.Controller;

import Projeto.example.HackaGabaritos.Model.Turma;
import Projeto.example.HackaGabaritos.Service.TurmaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;
    public TurmaController(TurmaService service) { this.service = service; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("turmas", service.listar());
        return "turma/list";  // renderiza turma/list.html
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("turma", new Turma());
        return "turma/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Turma turma) {
        service.salvar(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Turma t = service.buscarPorId(id).orElseThrow();
        model.addAttribute("turma", t);
        return "turma/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/turmas";
    }
}
