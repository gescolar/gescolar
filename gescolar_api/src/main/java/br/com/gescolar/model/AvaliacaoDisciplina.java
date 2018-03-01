package br.com.gescolar.model;


import java.io.Serializable;
import java.util.Date;

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
@Table(name="AVALIACAO_DISCIPLINA")
public class AvaliacaoDisciplina implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avaliacao_disciplina")
	private Long idAvaliacaoDisciplina;
	
	@NotNull
	private Double peso;
	
	@NotNull
	private String tipo;
	
	@NotNull
	private String avaliacao;
	
	private String descricao;
	
	@NotNull
	private Date data;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_disciplina_turma")
	private DisciplinaTurma disciplinaTurma;
	
	
	
	public Long getIdAvaliacaoDisciplina() {
		return idAvaliacaoDisciplina;
	}
	public void setIdAvaliacaoDisciplina(Long idAvaliacaoDisciplina) {
		this.idAvaliacaoDisciplina = idAvaliacaoDisciplina;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public DisciplinaTurma getDisciplinaTurma() {
		return disciplinaTurma;
	}
	public void setDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		this.disciplinaTurma = disciplinaTurma;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAvaliacaoDisciplina == null) ? 0 : idAvaliacaoDisciplina.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		AvaliacaoDisciplina other = (AvaliacaoDisciplina) obj;
		if (idAvaliacaoDisciplina == null) {
			if (other.idAvaliacaoDisciplina != null)
				return false;
		} else if (!idAvaliacaoDisciplina.equals(other.idAvaliacaoDisciplina))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	
	
	
}
