package br.com.db1.pedidos.pedidos.api.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
import br.com.db1.pedidos.pedidos.api.domain.entity.Pedido;
import br.com.db1.pedidos.pedidos.api.repositorio.PedidoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoRepositoryTest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@After
	public void after() {
		pedidoRepository.deleteAll();
	}

	@Test
	public void deveSalvarUmPedido() {
		Cliente cliente = new Cliente("Fabio", "12345678910");
		Pedido pedido = new Pedido(cliente, "12345");
		pedidoRepository.save(pedido);

		long count = pedidoRepository.count();

		Assert.assertEquals(1, count);

	}

}
