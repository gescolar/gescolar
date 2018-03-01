package br.com.gescolar.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="PERIODO_LETIVO")
public class PeriodoLetivo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_periodo_letivo")
	private Long idPeriodoLetivo;
	
	@NotNull
	private Date dataIni;
	@NotNull
	private Date dataFim;
	@NotNull
	private String turno;
	@NotNull
	private String situacao;
	@NotNull
	private Integer minPeriodo;
	
	public Long getIdPeriodoLetivo() {
		return idPeriodoLetivo;
	}
	public void setIdPeriodoLetivo(Long idPeriodoLetivo) {
		this.idPeriodoLetivo = idPeriodoLetivo;
	}
	public Date getDataIni() {
		return dataIni;
	}
	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Integer getMinPeriodo() {
		return minPeriodo;
	}
	public void setMinPeriodo(Integer minPeriodo) {
		this.minPeriodo = minPeriodo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataIni == null) ? 0 : dataIni.hashCode());
		result = prime * result + ((idPeriodoLetivo == null) ? 0 : idPeriodoLetivo.hashCode());
		result = prime * result + ((minPeriodo == null) ? 0 : minPeriodo.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
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
		PeriodoLetivo other = (PeriodoLetivo) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataIni == null) {
			if (other.dataIni != null)
				return false;
		} else if (!dataIni.equals(other.dataIni))
			return false;
		if (idPeriodoLetivo == null) {
			if (other.idPeriodoLetivo != null)
				return false;
		} else if (!idPeriodoLetivo.equals(other.idPeriodoLetivo))
			return false;
		if (minPeriodo == null) {
			if (other.minPeriodo != null)
				return false;
		} else if (!minPeriodo.equals(other.minPeriodo))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		return true;
	}
	
	
	
}
