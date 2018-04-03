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
	@Column(name="codigo")
	private Long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_periodo_letivo")
	private PeriodoLetivo periodoLetivo;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluno> alunosList;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DisciplinaTurma> disciplinasList;
	
	private String serie;
	
	private String sala;
	
	@Column(name="quantidade_periodos")
	private Integer quantPeriodosSemana;
	
	@Column(name="quantidade_dias")
	private Integer quantDias;
	
	private Integer vagas;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PeriodoLetivo getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Integer getQuantPeriodosSemana() {
		return quantPeriodosSemana;
	}

	public void setQuantPeriodosSemana(Integer quantPeriodosSemana) {
		this.quantPeriodosSemana = quantPeriodosSemana;
	}

	public Integer getQuantDias() {
		return quantDias;
	}

	public void setQuantDias(Integer quantDias) {
		this.quantDias = quantDias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}
	
	
	
}
