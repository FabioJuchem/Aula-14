package br.com.db1.projeto.pedidosTest;

    
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.db1.projeto.pedidos.Cliente;
import br.com.db1.projeto.pedidos.Pedido;
import br.com.db1.projeto.pedidos.Produto;
import br.com.db1.projeto.pedidos.StatusCliente;
import br.com.db1.projeto.pedidos.StatusPedido;

public class PedidosTest {
	
	private Pedido pedido;
	Produto prod1 = new Produto("12345","Manga",10.0);
	Produto prod2 = new Produto("54321","Pamonha", 5.0);
	
	
	@Before
	public void init() {
		Cliente cliente = new Cliente("Fabio Juchem","12345678911",StatusCliente.ATIVO);
		
		pedido = new Pedido(StatusPedido.ABERTO,cliente,"1010");
	}
	@Test
	public void deveAdicionarItens() {
		pedido.adicionarItensAoPedido(prod1,1.0);
		pedido.adicionarItensAoPedido(prod2,1.0);
		Assert.assertEquals(2,pedido.getItens().size());
	}

}