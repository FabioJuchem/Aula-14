package br.com.db1.projeto.pedidos;

public class PedidoItem {

	private Produto produto;
	private Double quantidade;
	private Double valorTotal;

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
		return this.valorTotal * quantidade;
	}
	public Produto getProduto(){
		return this.produto;
	}
	
	public void valorTotal() {
		this.valorTotal = this.produto.getValor() * quantidade;
	}
	public void adicionarQuantidade(Double quantidade) {
		this.quantidade = this.quantidade + quantidade; 
	}
	public void removerQuantidade(Double quantidade) {
		this.quantidade = this.quantidade - quantidade; 
	}
	

}