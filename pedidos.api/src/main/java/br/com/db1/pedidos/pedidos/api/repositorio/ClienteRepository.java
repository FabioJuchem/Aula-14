package br.com.db1.pedidos.pedidos.api.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidos.api.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	Cliente findByCpf(String cpf);

}
