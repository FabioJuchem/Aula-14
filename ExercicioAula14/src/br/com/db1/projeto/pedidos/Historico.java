package br.com.db1.projeto.pedidos;

import java.time.LocalDateTime;

public class Historico {

	private LocalDateTime data;
	private StatusPedido status;

	// construtores
	public Historico(StatusPedido status) {

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

}