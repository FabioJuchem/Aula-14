package br.com.db1.pedidos.pedidos.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidos.api.infraestrutura.Checker;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo",length=50, nullable = false ,unique=true)
	private String codigo;
	
	@Column(name = "nome",length=100, nullable = false )
	private String nome;
	
	@Column(name = "valor",precision=16,scale=2,nullable = false )
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status",length=30, nullable = false)
	private ProdutoStatus status;

	protected Produto(){}
	
	//construtores
	public Produto(String codigo, String nome, Double valor) {
		Checker.notNull(codigo, "codigo");
		Checker.notNull(nome, "nome");
		Checker.notNull(valor, "valor");
		Checker.tamanhoDoCodigoDoProduto(codigo, "codigo");
		
		this.status = ProdutoStatus.ATIVO;
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
	public void Inativar(){
		this.status = ProdutoStatus.INATIVO;
	}
	public boolean produtoIsAtivo(){
		if(this.status == ProdutoStatus.ATIVO){
			return true;
		}else{
			return false;
		}
	}

}