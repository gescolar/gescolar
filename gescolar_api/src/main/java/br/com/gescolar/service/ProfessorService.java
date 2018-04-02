package br.com.gescolar.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gescolar.model.Professor;
import br.com.gescolar.model.Usuario;
import br.com.gescolar.repository.ProfessorRepository;
import br.com.gescolar.types.TipoUsuarioEnum;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FotoService fotoService;
	
	public Professor atualizar(Long codigo, Professor professor) {
		Professor professorSalvo = buscarPessoaPeloCodigo(codigo);
		fotoService.atualizar(professorSalvo.getFoto(), professor.getFoto());
		BeanUtils.copyProperties(professor, professorSalvo, "idProfessor","usuario");
		return professorRepository.save(professorSalvo);
	}

	public Professor buscarPessoaPeloCodigo(Long codigo) {
		Professor professorSalvo = professorRepository.findOne(codigo);
		if (professorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return professorSalvo;
	}
	
	@Transactional
	public Professor salvar(Professor professor) {
		Usuario usuario = usuarioService.gerarUsuarioDefault(professor.getNome(), TipoUsuarioEnum.PROFESSOR);
		professor.setUsuario(usuario);
		fotoService.salvar(professor.getFoto());
		return this.professorRepository.save(professor);
	}
	
}
