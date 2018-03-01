package br.com.gescolar.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="TURMA")
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_turma")
	private Long idTurma;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_periodo_letivo")
	private PeriodoLetivo periodoLetivo;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluno> alunosList;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DisciplinaTurma> disciplinasList;
	
	private String serie;
	
	private String sala;
	
	private Integer quantPeriodosSemana;
	
	
	
	public Long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public PeriodoLetivo getPeriodoLetivo() {
		return periodoLetivo;
	}
	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public Integer getQuantPeriodosSemana() {
		return quantPeriodosSemana;
	}
	public void setQuantPeriodosSemana(Integer quantPeriodosSemana) {
		this.quantPeriodosSemana = quantPeriodosSemana;
	}
	public List<Aluno> getAlunosList() {
		return alunosList;
	}
	public void setAlunosList(List<Aluno> alunosList) {
		this.alunosList = alunosList;
	}
	public List<DisciplinaTurma> getDisciplinasList() {
		return disciplinasList;
	}
	public void setDisciplinasList(List<DisciplinaTurma> disciplinasList) {
		this.disciplinasList = disciplinasList;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
		result = prime * result + ((periodoLetivo == null) ? 0 : periodoLetivo.hashCode());
		result = prime * result + ((quantPeriodosSemana == null) ? 0 : quantPeriodosSemana.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
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
		Turma other = (Turma) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		if (periodoLetivo == null) {
			if (other.periodoLetivo != null)
				return false;
		} else if (!periodoLetivo.equals(other.periodoLetivo))
			return false;
		if (quantPeriodosSemana == null) {
			if (other.quantPeriodosSemana != null)
				return false;
		} else if (!quantPeriodosSemana.equals(other.quantPeriodosSemana))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}
	
	
	
}
