package br.com.db1.projeto.pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	StatusPedido status;
	Cliente cliente;
	List<PedidoItem> itens = new ArrayList<>();
	String numeroPedido;
	
	
	//construtores
	public Pedido(StatusPedido status, Cliente cliente, List<PedidoItem> itens, String numeroPedido) {
		Checker.notNull(cliente, "cliente");
		Checker.notNull(numeroPedido, "numeroPedido");
		
		this.status = status;
		this.cliente = cliente;
		this.itens = itens;
		this.numeroPedido = numeroPedido;
		
		
	}
	
	
	
	

}
