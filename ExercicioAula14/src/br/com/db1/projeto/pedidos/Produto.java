package br.com.db1.projeto.pedidos;

public class Produto {

	private String codigo;
	private String nome;
	private Double valor;
	private ProdutoStatus status;

	
	//construtores
	public Produto(String codigo, String nome, Double valor) {
		Checker.notNull(codigo, "codigo");
		Checker.notNull(nome, "nome");
		Checker.notNull(valor, "valor");
		Checker.tamanhoDoCodigoDoProduto(codigo, "codigo");
		
		this.status = status.ATIVO;
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
	public ProdutoStatus getStatus(){
		return this.status;
	}
	public void Inativar(ProdutoStatus status){
		this.status = status;
	}
	public boolean produtoIsAtivo(){
		if(this.status == status.ATIVO){
			return true;
		}else{
			return false;
		}
	}

}