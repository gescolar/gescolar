package br.com.gescolar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import br.com.gescolar.model.Professor;
import br.com.gescolar.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	public Professor atualizar(Long codigo, Professor professor) {
		Professor professorSalvo = buscarPessoaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(professor, professorSalvo, "codigo");
		return professorRepository.save(professorSalvo);
	}

	public Professor buscarPessoaPeloCodigo(Long codigo) {
		Professor professorSalvo = professorRepository.findOne(codigo);
		if (professorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return professorSalvo;
	}
	
}
