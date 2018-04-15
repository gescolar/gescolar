package br.com.gescolar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gescolar.model.Aluno;
import br.com.gescolar.model.Usuario;
import br.com.gescolar.repository.AlunoRepository;
import br.com.gescolar.types.TipoUsuarioEnum;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FotoService fotoService;
	
	
	public Aluno salvar(Aluno aluno) {
		Usuario usuario = usuarioService.gerarUsuarioDefault(aluno.getMatricula(), TipoUsuarioEnum.ALUNO_RESPONSSAVEL);
		aluno.setUsuario(usuario);
		fotoService.salvar(aluno.getFoto());
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizar(Long codigo, Aluno aluno) {
		Aluno alunoSalvo = buscarAlunoPeloCodigo(codigo);
		fotoService.atualizar(alunoSalvo.getFoto(), aluno.getFoto());
		BeanUtils.copyProperties(aluno, alunoSalvo, "idAluno","usuario");
		return alunoRepository.save(alunoSalvo);
	}
	
	public Aluno deletar() {
		return null;
	}
	
	public Aluno buscarAlunoPeloCodigo(Long codigo) {
		Aluno AlunoSalvo = alunoRepository.findOne(codigo);
		if (AlunoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return AlunoSalvo;
	}

	public boolean verificaMatricula(String matricula, Long codigo) {
		if (codigo != null) {
			Aluno aluno = this.buscarAlunoPeloCodigo(codigo);
			if (aluno.getMatricula().equals(matricula)) return false;
		}
		return alunoRepository.existsByMatricula(matricula);
	}
	
}
