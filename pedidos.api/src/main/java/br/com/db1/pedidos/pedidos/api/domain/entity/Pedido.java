package br.com.db1.pedidos.pedidos.api.domain.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Checker;

@Entity
@Table(name = "pedido_historico")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 50)
	private StatusPedido status;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Historico> historicos = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoItem> itens = new ArrayList<>();
	
	@Column(name = "codigo", nullable = false, length = 50)
	private String numeroPedido;
	
	protected Pedido(){}
	

	// construtores
	public Pedido(Cliente cliente, String numeroPedido) {
		Checker.notNull(cliente, "cliente");
		Checker.notNull(numeroPedido, "numeroPedido");
		if (numeroPedido.length() != 5) {
			throw new RuntimeException("Tamanho do numero incorreto");

		}
		if (!cliente.isAtivo()) {
			throw new RuntimeException("Cliente inativo");
		}

		this.status = StatusPedido.ABERTO;

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
		
		if(this.status != StatusPedido.ABERTO ){
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
		if (this.status == StatusPedido.ABERTO && this.cliente.isAtivo() == true && this.itens.size() > 0) {
			this.status = StatusPedido.FATURADO;
			mudarStatusDoPedido(status);
		} else {
			throw new RuntimeException("Existem problemas no pedido");
		}
	}

	public void cancelar() {
		if (this.status == StatusPedido.ABERTO) {
			this.status = StatusPedido.CANCELADO;
			mudarStatusDoPedido(status);
		} else {
			throw new RuntimeException("Status invalido");
		}
	}

}