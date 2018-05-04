package br.com.gescolar.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.gescolar.types.SerieEnum;
import br.com.gescolar.types.TurnoEnum;


@Entity
@Table(name="TURMA")
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@NotNull
	@NotBlank
	private String nome;
	
	private String sala;
	
	@Enumerated(EnumType.STRING)
	private SerieEnum serie;
	
	@Enumerated(EnumType.STRING)
	private TurnoEnum turno;
	
	@Column(name="quant_dias_semana")
	private Integer quantidadeDiasSemana;
	
	private Integer vagas;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluno> alunos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DisciplinaTurma> disciplinas;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TurmaPeriodo> periodos;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_periodo_letivo")
	@JsonIgnore
	private PeriodoLetivo periodoLetivo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public SerieEnum getSerie() {
		return serie;
	}

	public void setSerie(SerieEnum serie) {
		this.serie = serie;
	}

	public TurnoEnum getTurno() {
		return turno;
	}

	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}

	public Integer getQuantidadeDiasSemana() {
		return quantidadeDiasSemana;
	}

	public void setQuantidadeDiasSemana(Integer quantidadeDiasSemana) {
		this.quantidadeDiasSemana = quantidadeDiasSemana;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<DisciplinaTurma> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaTurma> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<TurmaPeriodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<TurmaPeriodo> periodos) {
		this.periodos = periodos;
	}

	public PeriodoLetivo getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}
	
	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
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
	
	
	
	
	
	
}
