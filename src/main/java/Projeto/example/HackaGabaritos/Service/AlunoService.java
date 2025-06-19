package Projeto.example.HackaGabaritos.Service;

import Projeto.example.HackaGabaritos.Model.Aluno;
import Projeto.example.HackaGabaritos.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public List<Aluno> listar() {
        return repo.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return repo.save(aluno);
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }
}


