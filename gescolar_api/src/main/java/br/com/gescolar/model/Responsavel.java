package br.com.gescolar.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="responsavel")
public class Responsavel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	
	@NotNull
	@NotBlank
	@Length(min=4, max= 50)
	private String nome;
	
	
	@NotNull
	@Length(max= 50)
	private String cpf;
	
	@Length(max= 50)
	private String parentesco;
	
	@Length(max= 50)
	private String telefone;
	
	@Length(max= 50)
	private String celular;
	
	@Length(max= 50)
	private String email;
	
	@Length(max= 50)
	private String sexo;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "responsavel_aluno", 
	joinColumns = @JoinColumn(name = "codigo_responsavel"), 
	inverseJoinColumns = @JoinColumn(name = "codigo_aluno"))
	private List<Aluno> alunosList;


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


	public String getParentesco() {
		return parentesco;
	}


	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Aluno> getAlunosList() {
		return alunosList;
	}


	public void setAlunosList(List<Aluno> alunosList) {
		this.alunosList = alunosList;
	}

	
	
	

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		Responsavel other = (Responsavel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
}
