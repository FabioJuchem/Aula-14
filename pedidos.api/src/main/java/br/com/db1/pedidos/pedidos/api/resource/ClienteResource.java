package br.com.db1.pedidos.pedidos.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidos.api.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidos.api.domain.entity.StatusCliente;
import br.com.db1.pedidos.pedidos.api.services.ClienteService;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDTO> getByStatus(@RequestParam("status") StatusCliente status) {
		return clienteService.getByStatus(status);
	}

	@PostMapping
	public ClienteDTO post(@RequestBody ClienteDTO body) {
		return clienteService.salvar(body);

	}

	@PutMapping(path = "/{id}")
	public ClienteDTO put(@PathVariable("id") Long id, @RequestBody ClienteDTO body) {
		return clienteService.alterar(id, body);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}

}
