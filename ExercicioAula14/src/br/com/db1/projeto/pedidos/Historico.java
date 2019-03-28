package br.com.db1.projeto.pedidos;

import java.time.LocalDateTime;

public class Historico {
	
	LocalDateTime data;
	StatusPedido Status;
	
	//construtores
	public Historico(StatusPedido status) {
		this.data = LocalDateTime.now();
		this.Status = status;
	}


	
	
}
