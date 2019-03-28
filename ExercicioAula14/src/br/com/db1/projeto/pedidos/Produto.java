package br.com.db1.projeto.pedidos;

public class Produto {

	String codigo;
	String nome;
	Double valor;

	
	//construtores
	public Produto(String codigo, String nome, Double valor) {
	
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return this.nome;
	}

	public Double getValor() {
		return this.valor;
	}

	public String getCodigo() {
		return this.codigo;
	}

}