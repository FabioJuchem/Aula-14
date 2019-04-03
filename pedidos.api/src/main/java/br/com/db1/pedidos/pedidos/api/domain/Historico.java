package br.com.db1.pedidos.pedidos.api.domain;

import java.time.LocalDateTime;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Checker;

public class Historico {

	private LocalDateTime data;
	private StatusPedido status;

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