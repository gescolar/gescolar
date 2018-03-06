package br.com.gescolar.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gescolar.model.Aluno;


public interface AlunoRepository  extends JpaRepository<Aluno, Long> {
	
	
}
