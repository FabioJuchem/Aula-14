package br.com.db1.pedidos.pedidos.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidos.api.infraestrutura.Checker;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 30, nullable = false)
	private StatusCliente status;

	public Cliente(String string, String string2, StatusCliente statusCliente) {
	}
	

	// construtores
	public Cliente(){}
	
	public Cliente(String nome, String cpf) {
		Checker.notNull(nome, "nome");
		Checker.notNull(cpf, "cpf");
		Checker.tamanhoCpfIncorreto(cpf, "cpf");
		
		
		this.nome = nome;
		this.cpf = cpf;
		this.status = StatusCliente.ATIVO;
	}

	public void setCpf(String cpf){
		Checker.notNull(cpf, "cpf");
		Checker.tamanhoCpfIncorreto(cpf, "cpf");
		this.cpf = cpf;
	}
	public void setNome(String nome){
		Checker.notNull(nome, "nome");
		this.nome = nome;
	}
	
	// metodos
	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public StatusCliente getStatus() {
		return this.status;
	}

	public void inativarCliente() {
		this.status = StatusCliente.INATIVO;
	}

	public boolean isAtivo() {
		return StatusCliente.ATIVO.equals(this.status);
	}

	public Long getId() {
		return this.id;
	}


	public void marcarComoExcluido() {
		this.status = StatusCliente.EXCLUIDO;
		
	}

}