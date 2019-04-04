package br.com.db1.pedidos.pedidos.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	Cliente findByCpf(String cpf);

}
