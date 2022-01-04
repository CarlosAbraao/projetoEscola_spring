package com.example.colegio.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.example.colegio.Enuns.Curso;
import com.example.colegio.Enuns.Status;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	@NotBlank(message ="O campo não pode ser vazio")// NÃO PODE SER NULO NEM VAZIO
    @Size(min = 5, max = 20,message= "O nome deve conter no mínimo 5 caracteres")
	@Column(name ="nome")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo curso não pode ser nulo")
	@Column(name = "curso")
	private Curso curso;
	
	@NotBlank(message="Informe a matricula")
	@Column(name = "matricula")
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="O campo status não pode ser nulo")
	@Column(name = "status")
	private Status status;
	
	@Column(name = "turno")
	private String turno;
	
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	

}
