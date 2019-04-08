package br.com.db1.pedidos.pedidos.api.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidos.api.infraestrutura.Checker;

@Entity
@Table(name = "historico")
public class Historico {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data", nullable = false)
	private LocalDateTime data;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 30, nullable = false)
	private StatusPedido status;
	
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	protected Historico (){}

	// construtores
	
	
	public Historico(StatusPedido status) {
		Checker.notNull(status, "status");
		this.data = LocalDateTime.now();
		this.status = status;
		
		
		
	}
	

	
	//metodos
	public StatusPedido getStatus() {
		return this.status;
	
	}

	public LocalDateTime getData() {
		return this.data;
	}
	
	public void setStatus(StatusPedido status){
		this.status = status;
	}

}