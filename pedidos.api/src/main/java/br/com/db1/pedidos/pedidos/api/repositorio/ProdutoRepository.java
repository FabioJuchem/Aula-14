package br.com.db1.pedidos.pedidos.api.repositorio;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidos.api.domain.entity.Produto;
import br.com.db1.pedidos.pedidos.api.domain.entity.ProdutoStatus;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Produto findByCodigo(String codigo);
	
	Iterable<Produto> findByStatus(ProdutoStatus status);
	

}
