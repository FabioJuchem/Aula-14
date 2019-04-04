package br.com.db1.pedidos.pedidos.api.repositorio;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidos.api.domain.entity.PedidoItem;


@Repository
public interface PedidoItemRepository extends CrudRepository<PedidoItem, Long>{
	
	PedidoItem findByproduto(PedidoItem produto);
	
	

}