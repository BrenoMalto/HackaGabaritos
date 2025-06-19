package Projeto.example.HackaGabaritos.Controller;

import Projeto.example.HackaGabaritos.Model.Aluno;
import Projeto.example.HackaGabaritos.Service.AlunoService;
import Projeto.example.HackaGabaritos.Service.TurmaService;
import Projeto.example.HackaGabaritos.Service.DisciplinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final TurmaService turmaService;
    private final DisciplinaService disciplinaService;

    public AlunoController(AlunoService alunoService, TurmaService turmaService, DisciplinaService disciplinaService) {
        this.alunoService = alunoService;
        this.turmaService = turmaService;
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listar());
        return "aluno/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("turmas", turmaService.listar());
        model.addAttribute("disciplinas", disciplinaService.listar());
        return "aluno/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id).orElseThrow();
        model.addAttribute("aluno", aluno);
        model.addAttribute("turmas", turmaService.listar());
        model.addAttribute("disciplinas", disciplinaService.listar());
        return "aluno/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        alunoService.excluir(id);
        return "redirect:/alunos";
    }
}


