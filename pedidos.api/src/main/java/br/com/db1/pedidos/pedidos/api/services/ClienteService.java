package br.com.db1.pedidos.pedidos.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidos.api.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidos.api.domain.entity.Cliente;
import br.com.db1.pedidos.pedidos.api.repositorio.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> getAll(){
		Iterable<Cliente> clientesDataBase = clienteRepository.findAll();
		Iterator<Cliente> iterator = clientesDataBase.iterator();
		
		List<ClienteDTO> clientes = new ArrayList<>();
		
		while(iterator.hasNext()){
			Cliente next = iterator.next();
			ClienteDTO clienteDTO = new ClienteDTO(next.getNome(),next.getCPF());
			clientes.add(clienteDTO);
		}
		
		return clientes;
	}

}
