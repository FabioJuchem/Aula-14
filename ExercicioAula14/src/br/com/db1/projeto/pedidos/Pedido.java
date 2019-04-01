package br.com.db1.projeto.pedidos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {

	private StatusPedido status;
	private Cliente cliente;
	private List<PedidoItem> itens = new ArrayList<>();
	private String numeroPedido;

	// construtores
	public Pedido(Cliente cliente, String numeroPedido) {
		Checker.notNull(cliente, "cliente");
		Checker.notNull(numeroPedido, "numeroPedido");
		if (numeroPedido.length() != 5) {
			throw new RuntimeException("Tamanho do numero incorreto");

		}
		if (cliente.getStatus() != cliente.getStatus().ATIVO) {
			throw new RuntimeException("Cliente inativo");
		}

		this.status = status.ABERTO;

		this.cliente = cliente;
		this.numeroPedido = numeroPedido;

		this.status.historico(status);

	}

	// metodos

	public Cliente getCliente() {
		return this.cliente;
	}

	public String getNumeroPedido() {
		return this.numeroPedido;
	}

	public List<PedidoItem> getItens() {
		return this.itens;
	}

	public StatusPedido getStatus() {
		return this.status;

	}

	public void adicionarItensAoPedido(Produto produto, Double quantidade) {
		this.itens.add(new PedidoItem(produto, quantidade));
	}

	public void removerProduto(Produto item) {
		
		if(this.status != status.ABERTO ){
			throw new RuntimeException("Pedido com status incorreto");
		}

		Iterator<PedidoItem> i = itens.iterator();
		while (i.hasNext()) {
			PedidoItem e = i.next();
			if (e.getProduto().equals(item)) {
				i.remove();
			}
				
			
		}

	}

	private void mudarStatusDoPedido(StatusPedido status) {
		this.status = status;
		this.status.historico(status);
	}

	public void faturarPedido() {
		if (this.status == status.ABERTO && this.cliente.isAtivo() == true && this.itens.size() > 0) {
			this.status = status.FATURADO;
			mudarStatusDoPedido(status);
		} else {
			throw new RuntimeException("Existem problemas no pedido");
		}
	}

	public void cancelar() {
		if (this.status == status.ABERTO) {
			this.status = status.CANCELADO;
			mudarStatusDoPedido(status);
		} else {
			throw new RuntimeException("Status invalido");
		}
	}

}