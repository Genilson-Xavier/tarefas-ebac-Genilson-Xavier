package br.com.projeto1.Dao;

import java.util.Collection;

import br.com.projeto1.Model.Cliente;

public interface IClienteDao {
	
	public Boolean cadastrar(Cliente cliente);
	
	public void excluir(Long cpf);
	
	public void alterar(Cliente cliente);
	
	public Cliente consultar(Long cpf);
	
	public Collection<Cliente> buscarTodos();
	
}
