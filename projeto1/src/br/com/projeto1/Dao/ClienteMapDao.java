package br.com.projeto1.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.projeto1.Model.Cliente;

public class ClienteMapDao implements IClienteDao {

	private Map<Long, Cliente> map;
	
	public ClienteMapDao() {
		this.map = new HashMap<>();
	}
	
	@Override
	public Boolean cadastrar(Cliente cliente) {
		if(this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		this.map.put(cliente.getCpf(), cliente);
		return true;
	}

	@Override
	public void excluir(Long cpf) {
		Cliente clienteCadastrado = this.map.get(cpf);
		
		if(clienteCadastrado != null) {
			this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
		}
		
	}

	@Override
	public void alterar(Cliente cliente) {
		Cliente clienteCadastrado = this.map.get(cliente.getCpf());
		
		if(clienteCadastrado != null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setCpf(cliente.getCpf());
			clienteCadastrado.setTelefone(cliente.getTelefone());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setEndereco(cliente.getEndereco());
			clienteCadastrado.setEstado(cliente.getEstado());
			clienteCadastrado.setNumero(cliente.getNumero());
		}
		
	}

	@Override
	public Cliente consultar(Long cpf) {
		
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		
		return this.map.values();
	}

}
