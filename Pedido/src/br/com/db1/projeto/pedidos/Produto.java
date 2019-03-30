package br.com.db1.projeto.pedidos;

public class Produto {

	private String codigo;
	private String nome;
	private Double valor;

	
	//construtores
	public Produto(String codigo, String nome, Double valor) {
		Checker.notNull(codigo, "codigo");
		Checker.notNull(nome, "nome");
		Checker.notNull(valor, "valor");
		Checker.tamanhoDoCodigoDoProduto(codigo, "codigo");
	
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