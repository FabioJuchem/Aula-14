package br.com.db1.pedidos.pedidos.api.repositorio;





import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidos.api.domain.entity.Historico;


@Repository
public interface HistoricoRepository extends CrudRepository<Historico, Long>{
	
	
	Historico findBydata(LocalDateTime data);
	

}