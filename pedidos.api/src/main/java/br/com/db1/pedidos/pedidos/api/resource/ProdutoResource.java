package br.com.db1.pedidos.pedidos.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidos.api.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidos.api.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidos.api.services.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {
	
	@Autowired 
	private ProdutoService produtoService;
	
	@GetMapping(path = "/ativos")
	public List<ProdutoDTO> getAll(){
		return produtoService.getAllActive();
	}
	
	@GetMapping
	public List<ProdutoDTO> getByStatus(@RequestParam("status")ProdutoStatus status){
		return produtoService.getByStatus(status);
	}
	
	@PostMapping
	public ProdutoDTO post(@RequestBody ProdutoDTO body){
		return produtoService.salvar(body);
		
		
	}
	

}
