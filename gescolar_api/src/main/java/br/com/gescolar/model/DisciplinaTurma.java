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
@Table(name="DISCIPLINA_TURMA")
public class DisciplinaTurma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_discipla_turma")
	private Long idDisciplinaTurma;
	
	@NotNull
	private Integer quantPeriodosSemana;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	public Long getIdDisciplinaTurma() {
		return idDisciplinaTurma;
	}
	public void setIdDisciplinaTurma(Long idDisciplinaTurma) {
		this.idDisciplinaTurma = idDisciplinaTurma;
	}
	
	public Integer getQuantPeriodosSemana() {
		return quantPeriodosSemana;
	}
	public void setQuantPeriodosSemana(Integer quantPeriodosSemana) {
		this.quantPeriodosSemana = quantPeriodosSemana;
	}
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDisciplinaTurma == null) ? 0 : idDisciplinaTurma.hashCode());
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
		DisciplinaTurma other = (DisciplinaTurma) obj;
		if (idDisciplinaTurma == null) {
			if (other.idDisciplinaTurma != null)
				return false;
		} else if (!idDisciplinaTurma.equals(other.idDisciplinaTurma))
			return false;
		return true;
	}
	
	
}
