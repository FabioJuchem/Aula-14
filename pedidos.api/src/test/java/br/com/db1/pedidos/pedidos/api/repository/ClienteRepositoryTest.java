package br.com.db1.pedidos.pedidos.api.repository;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
import br.com.db1.pedidos.pedidos.api.domain.entity.StatusCliente;
import br.com.db1.pedidos.pedidos.api.repositorio.ClienteRepository;


@RunWith(SpringRunner.class)                            
@SpringBootTest
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@After 
	public void after(){
		clienteRepository.deleteAll();
	}
	
	
	@Test
	public void deveSalvarUmNovoCliente(){
		Cliente cliente = new Cliente("Fabio", "12345678910");
		clienteRepository.save(cliente);
		long count = clienteRepository.count();
		
		Assert.assertEquals(1, count);
	}
	
	@Test
	public void deveSalvarClienteAlterado(){
		Cliente cliente = new Cliente("Joana","99999999999");
		
		
		clienteRepository.save(cliente);
		Cliente clienteSalvo = clienteRepository.findByCpf("99999999999");
		
		clienteSalvo.inativarCliente();
		clienteRepository.save(clienteSalvo);
		
		Cliente clienteAlterado = clienteRepository.findByCpf("99999999999");
		
		Assert.assertEquals(StatusCliente.INATIVO,clienteAlterado.getStatus());
		
		
	}

}
