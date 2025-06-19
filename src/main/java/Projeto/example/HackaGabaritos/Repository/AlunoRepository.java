package Projeto.example.HackaGabaritos.Repository;

import Projeto.example.HackaGabaritos.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}


