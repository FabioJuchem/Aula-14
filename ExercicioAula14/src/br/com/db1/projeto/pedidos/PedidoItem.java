package br.com.db1.projeto.pedidos;

import java.util.List;

public class PedidoItem {

	Produto produto;
	Double quantidade;
	Double valor;

	//construtores
	public PedidoItem(Produto produto, Double quantidade,Double valor) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Double getValor() {
		return this.valor;
	}

	public Double getQuantidade() {
		return this.quantidade;
	}
	
	

}
