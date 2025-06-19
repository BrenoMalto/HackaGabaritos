package Projeto.example.HackaGabaritos.Repository;

import Projeto.example.HackaGabaritos.Model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}


