package br.com.db1.pedidos.pedidos.api.domain;

import java.util.ArrayList;
import java.util.List;

public enum StatusPedido {
	
	CANCELADO,ABERTO,FATURADO;
	
	private List<Historico> historicos = new ArrayList<>();
	
	public void historico(StatusPedido status) {
		Historico historico = new Historico(status);
		this.historicos.add(historico);
	}
	

}