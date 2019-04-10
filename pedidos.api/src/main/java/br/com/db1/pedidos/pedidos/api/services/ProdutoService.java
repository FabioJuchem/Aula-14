package br.com.db1.pedidos.pedidos.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidos.api.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidos.api.domain.entity.Produto;
import br.com.db1.pedidos.pedidos.api.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidos.api.repositorio.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> getAllActive() {
		return this.getByStatus(ProdutoStatus.ATIVO);
	}
	
	public List<ProdutoDTO> getByCodigo(String codigo){
		return produtoRepository.findByCodigo(codigo).stream().map(
				produto -> this.produtoToDto(produto)).collect(Collectors.toList());
	}
	
	
	public List<ProdutoDTO> getByStatus(ProdutoStatus status){
		return produtoRepository.findByStatus(status).stream().map(
				produto -> this.produtoToDto(produto)).collect(Collectors.toList());
	}
	public ProdutoDTO salvar(ProdutoDTO dto){
		Produto produto = new Produto(dto.getCodigo(),dto.getNome(),dto.getValor());
		Produto produtoSalvo = produtoRepository.save(produto);
		return this.produtoToDto(produtoSalvo);
	}
	
	private ProdutoDTO produtoToDto(Produto produto){
		return new ProdutoDTO(produto.getCodigo(),produto.getNome(),produto.getValor());
	}
}
