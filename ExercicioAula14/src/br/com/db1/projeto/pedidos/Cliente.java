package br.com.db1.projeto.pedidos;

import br.com.db1.projeto.pedidos.Checker;

public class Cliente {

	private String nome;
	private String cpf;
	private StatusCliente Status;

	// construtores
	public Cliente(String nome, String cpf, StatusCliente status) {
		Checker.notNull(nome, "nome");
		Checker.notNull(cpf, "cpf");

		if (cpf.length() < 9) {
			throw new RuntimeException("CPF invalido");
		}
		if (nome.isEmpty() == true) {
			throw new RuntimeException("Preencha o nome");
		}

		this.nome = nome;
		this.cpf = cpf;
		this.Status = status;
	}

	
	//metodos
	public String getNome() {
		return this.nome;
	}

	public String getCPF() {
		return this.cpf;
	}

}
