package br.com.gescolar.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="NOTA_ALUNO")
public class NotaAluno implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_nota_aluno")
	private Long idNotaAluno;
	
	@NotNull
	private Double nota;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_avaliacao_disciplina")
	private AvaliacaoDisciplina avaliacaoDisciplina;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	public Long getIdNotaAluno() {
		return idNotaAluno;
	}
	public void setIdNotaAluno(Long idNotaAluno) {
		this.idNotaAluno = idNotaAluno;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public AvaliacaoDisciplina getAvaliacaoDisciplina() {
		return avaliacaoDisciplina;
	}
	public void setAvaliacaoDisciplina(AvaliacaoDisciplina avaliacaoDisciplina) {
		this.avaliacaoDisciplina = avaliacaoDisciplina;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((idNotaAluno == null) ? 0 : idNotaAluno.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaAluno other = (NotaAluno) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (idNotaAluno == null) {
			if (other.idNotaAluno != null)
				return false;
		} else if (!idNotaAluno.equals(other.idNotaAluno))
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
