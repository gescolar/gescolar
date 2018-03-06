package br.com.gescolar.model;


import java.io.Serializable;
import java.time.LocalDate;

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
	@Column(name="data_ini")
	private LocalDate dataIni;
	@NotNull
	@Column(name="data_fim")
	private LocalDate dataFim;
	@NotNull
	private String turno;
	@NotNull
	private String situacao;
	@NotNull
	@Column(name="minutos_periodo")
	private Integer minPeriodo;
	
	public Long getIdPeriodoLetivo() {
		return idPeriodoLetivo;
	}
	public void setIdPeriodoLetivo(Long idPeriodoLetivo) {
		this.idPeriodoLetivo = idPeriodoLetivo;
	}
	public LocalDate getDataIni() {
		return dataIni;
	}
	public void setDataIni(LocalDate dataIni) {
		this.dataIni = dataIni;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
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
	
	
	
	
}
