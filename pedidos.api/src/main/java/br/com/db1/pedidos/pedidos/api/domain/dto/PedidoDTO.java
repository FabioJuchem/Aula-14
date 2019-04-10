package br.com.db1.pedidos.pedidos.api.domain.dto;

import java.io.Serializable;
import java.util.List;

public class PedidoDTO implements Serializable {

	public static final long serialVersionUID = 30L;

	private long idCliente;
	private List<PedidoItemDTO> item;

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public List<PedidoItemDTO> getItem() {
		return item;
	}

	public void setItem(List<PedidoItemDTO> item) {
		this.item = item;
	}

}
