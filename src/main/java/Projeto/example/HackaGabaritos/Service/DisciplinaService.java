package Projeto.example.HackaGabaritos.Service;

import Projeto.example.HackaGabaritos.Model.Disciplina;
import Projeto.example.HackaGabaritos.Repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    private final DisciplinaRepository repo;

    public DisciplinaService(DisciplinaRepository repo) {
        this.repo = repo;
    }

    public List<Disciplina> listar() {
        return repo.findAll();
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Disciplina salvar(Disciplina disciplina) {
        return repo.save(disciplina);
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }
}


