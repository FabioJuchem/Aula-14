package br.com.db1.pedidos.pedidos.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidos.api.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
import br.com.db1.pedidos.pedidos.api.domain.entity.StatusCliente;
import br.com.db1.pedidos.pedidos.api.repositorio.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> getAllActive() {
		return this.getByStatus(StatusCliente.ATIVO);
	}
	
	public List<ClienteDTO> getByStatus(StatusCliente status){
		return clienteRepository.findByStatus(StatusCliente.ATIVO).stream().map(
				cliente -> this.clienteToDto(cliente)).collect(Collectors.toList());
	}
	public ClienteDTO salvar(ClienteDTO dto){
		Cliente cliente = new Cliente(dto.getNome(),dto.getCpf());
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return this.clienteToDto(clienteSalvo);
	}
	
	private ClienteDTO clienteToDto(Cliente cliente){
		return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getStatus());
	}

	public ClienteDTO alterar(Long id, ClienteDTO body) {
		Cliente clienteDataBase = clienteRepository.getOne(id);
		clienteDataBase.setCpf(body.getCpf());
		clienteDataBase.setNome(body.getNome());
		clienteRepository.save(clienteDataBase);
		return this.clienteToDto(clienteDataBase);
	}
	
	
}
