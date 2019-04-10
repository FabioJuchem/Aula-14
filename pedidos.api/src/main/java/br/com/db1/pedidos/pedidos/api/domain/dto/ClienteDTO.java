package br.com.db1.pedidos.pedidos.api.domain.dto;

import java.io.Serializable;

import br.com.db1.pedidos.pedidos.api.domain.entity.StatusCliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -5708917156046748250L;
	private Long id;
	private String nome;
	private String cpf;
	private StatusCliente status;

	public ClienteDTO() {

	}

	public ClienteDTO(Long id, String nome, String cpf, StatusCliente status) {

		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public StatusCliente getStatus() {
		return status;
	}

	public void setStatus(StatusCliente status) {
		this.status = status;
	}

}
