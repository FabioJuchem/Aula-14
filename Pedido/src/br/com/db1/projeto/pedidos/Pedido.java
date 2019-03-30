package br.com.db1.projeto.pedidos;

import java.util.ArrayList;
import java.util.List;



public class Pedido {

	private StatusPedido status;
	private Cliente cliente;
	private List<PedidoItem> itens = new ArrayList<>();
	private String numeroPedido;

	// construtores
	public Pedido(StatusPedido status, Cliente cliente, String numeroPedido) {
		Checker.notNull(cliente, "cliente");
		Checker.notNull(numeroPedido, "numeroPedido");
		Checker.quantidadeMaximadeProdutos(itens);

		this.status = status;
		this.cliente = cliente;
		this.numeroPedido = numeroPedido;

	}
	
	//metodos
		
	public Cliente getCliente() {
		return this.cliente;
	}
	public String getNumeroPedido() {
		return this.numeroPedido;
	}
	public List<PedidoItem> getItens(){
		return this.itens;
	}
	public void adicionarItensAoPedido(Produto produto, Double quantidade) {
		this.itens.add(new PedidoItem(produto,quantidade));
	}
	public void removerProduto(PedidoItem produto) {
		this.itens.remove(produto);
	}
	public void mudarStatusDoPedido(StatusPedido status) {
		this.status = status;
		this.status.historico(status);
	}

	
}
