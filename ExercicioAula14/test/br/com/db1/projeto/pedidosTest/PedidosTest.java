package br.com.db1.projeto.pedidosTest;

    


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.db1.projeto.pedidos.Cliente;
import br.com.db1.projeto.pedidos.Pedido;
import br.com.db1.projeto.pedidos.Produto;
import br.com.db1.projeto.pedidos.ProdutoStatus;
import br.com.db1.projeto.pedidos.StatusCliente;
import br.com.db1.projeto.pedidos.StatusPedido;

public class PedidosTest {
	
	private Pedido pedido;
	private Pedido pedido2;

	Produto prod1 = new Produto("12345","Manga",10.0);
	Produto prod2 = new Produto("54321","Pamonha", 5.0);
	
	
	@Before
	public void init() {
		Cliente cliente = new Cliente("Fabio Juchem","12345678911");
		pedido = new Pedido(cliente,"10100");
		
		
	}
	@Test
	public void deveAdicionarItens() {
		pedido.adicionarItensAoPedido(prod1,1.0);
		pedido.adicionarItensAoPedido(prod2,1.0);
		Assert.assertEquals(2,pedido.getItens().size());
	}
	@Test
	public void deveRemoverItens() {
		pedido.adicionarItensAoPedido(prod1,1.0);
		pedido.adicionarItensAoPedido(prod2,1.0);
		pedido.removerProduto(prod1);
		Assert.assertEquals(1,pedido.getItens().size());
	}
	@Test
	public void deveRetornarNomeDoCLiente() {
		pedido.getCliente().getNome();
		Assert.assertEquals("Fabio Juchem",pedido.getCliente().getNome());
	}
	@Test(expected = RuntimeException.class)
	public void deveRetornarExceptionDeMaximoDeItens() {
		pedido.adicionarItensAoPedido(prod1,11.0);
	
	}
	
	@Test
	public void deveRetornarStatusDoPedido(){
		Assert.assertEquals(StatusPedido.ABERTO, pedido.getStatus());
	}
	
	@Test(expected = RuntimeException.class)
		public void deveRetornarErroDeTamanhoDoNumero(){
		Cliente cliente = new Cliente("Fabio Juchem","12345678911");
		pedido2 = new Pedido(cliente,"101011");
		
	}
	@Test(expected = RuntimeException.class)
	public void deveRetornarExceptionDeProdutoInativo(){
		prod1.Inativar(ProdutoStatus.INATIVO);
		pedido.adicionarItensAoPedido(prod1,1.0);
		pedido.adicionarItensAoPedido(prod2,1.0);
		}
	
	
	
	
	

	

	

}