package br.com.db1.pedidos.pedidos.api.repositorio;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidos.api.domain.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	Pedido findBynumeroPedido(String numeroPedido);
	
	

}