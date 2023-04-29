/**
 * 
 */
package main.java.br.com.dao;

import java.util.Collection;

import main.java.br.com.dao.exception.TipoChavenaoEncontradaException;
import main.java.br.com.domain.Cliente;

/**
 * @author Genilson Xavier
 *
 */
public class ClienteDaoMock implements IClienteDao{

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChavenaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(Long valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente entity) throws TipoChavenaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}



}
