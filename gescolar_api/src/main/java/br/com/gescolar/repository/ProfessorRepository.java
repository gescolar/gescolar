package br.com.gescolar.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gescolar.model.Professor;



public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
}
