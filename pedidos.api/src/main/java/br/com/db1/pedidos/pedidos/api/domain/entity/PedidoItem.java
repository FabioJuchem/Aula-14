package br.com.db1.pedidos.pedidos.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidos.api.infraestrutura.Checker;

@Entity
@Table(name = "pedido_item")
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;
	
	@Column(name = "quantidade", nullable = false, precision = 16, scale = 3)
	private Double quantidade;
	
	@Column(name = "valor_unitario", nullable = false, precision = 16, scale = 3)
	private Double valorUnitario;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	protected PedidoItem(){}

	//construtores
	public PedidoItem(Produto produto, Double quantidade) {
		Checker.notNull(produto, "produto");
		Checker.quantidadeMaximaDeItens(quantidade, "quantidade");
		if(produto.produtoIsAtivo()== false){
			throw new RuntimeException("Produto inativo");
		}
		
		
		this.produto = produto;
		this.quantidade = quantidade;
		
	}
	
	//metodos
	public Double getQuantidade() {
		return this.quantidade;
	}
	public Double getValorTotal() {
		return this.valorUnitario * quantidade;
	}
	public Produto getProduto(){
		return this.produto;
	}
	
	public Double valorTotal() {
		return this.produto.getValor() * quantidade;
	}
	public void adicionarQuantidade(Double quantidade) {
		this.quantidade = this.quantidade + quantidade; 
	}
	public void removerQuantidade(Double quantidade) {
		this.quantidade = this.quantidade - quantidade; 
	}
	

}