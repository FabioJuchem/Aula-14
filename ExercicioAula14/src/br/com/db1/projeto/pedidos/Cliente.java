package br.com.db1.projeto.pedidos;

import br.com.db1.projeto.pedidos.Checker;

public class Cliente {

	private String nome;
	private String cpf;
	private StatusCliente status;

	// construtores
	public Cliente(String nome, String cpf) {
		Checker.notNull(nome, "nome");
		Checker.notNull(cpf, "cpf");
		Checker.tamanhoCpfIncorreto(cpf, "cpf");
	
		this.nome = nome;
		this.cpf = cpf;
		this.status = status.ATIVO;
	}

	
	//metodos
	public String getNome() {
		return this.nome;
	}

	public String getCPF() {
		return this.cpf;
	}
	public StatusCliente getStatus() {
		return this.status;
	}
	public void inativarCliente(StatusCliente status){
		this.status = status;
	}
	public boolean isAtivo(){
		if(this.status == status.ATIVO){
			return true;
		}else{
			return false;
		}
	}


}