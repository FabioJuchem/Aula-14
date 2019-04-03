package br.com.db1.pedidos.pedidos.api.repositorio;



import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidos.api.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	Produto findByCodigo(String codigo);
	
	

}
