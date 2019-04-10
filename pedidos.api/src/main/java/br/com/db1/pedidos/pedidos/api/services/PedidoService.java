package br.com.db1.pedidos.pedidos.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidos.api.domain.dto.PedidoDTO;
import br.com.db1.pedidos.pedidos.api.domain.dto.PedidoItemDTO;
import br.com.db1.pedidos.pedidos.api.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
import br.com.db1.pedidos.pedidos.api.domain.entity.Pedido;
import br.com.db1.pedidos.pedidos.api.domain.entity.PedidoItem;
import br.com.db1.pedidos.pedidos.api.domain.entity.Produto;
import br.com.db1.pedidos.pedidos.api.repositorio.ClienteRepository;
import br.com.db1.pedidos.pedidos.api.repositorio.PedidoItemRepository;
import br.com.db1.pedidos.pedidos.api.repositorio.PedidoRepository;
import br.com.db1.pedidos.pedidos.api.repositorio.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoDTO salvar(PedidoDTO dto) {
		String codigoProduto = String.valueOf(System.currentTimeMillis());
		Cliente cliente = clienteRepository.getOne(dto.getIdCliente());
		Pedido pedido = new Pedido(cliente, codigoProduto);

		for (PedidoItemDTO itemDTO : dto.getItem()) {
			Produto produto = produtoRepository.findByCodigo(itemDTO.getCodigoProduto());
			pedido.adicionarItensAoPedido(produto, itemDTO.getQuantidade());
		}

		pedidoRepository.save(pedido);

		return dto;
	}

}
