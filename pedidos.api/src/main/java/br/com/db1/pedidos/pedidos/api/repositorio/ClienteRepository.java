package br.com.db1.pedidos.pedidos.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
import br.com.db1.pedidos.pedidos.api.domain.entity.StatusCliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByCpf(String cpf);
	
	List<Cliente> findByStatus(StatusCliente status);

}
