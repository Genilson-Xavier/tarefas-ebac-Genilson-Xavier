/**
 * 
 */
package main.java.br.com.services;

import main.java.br.com.dao.generics.GenericService;
import main.java.br.com.domain.Cliente;

/**
 * @author Genilson Xavier
 *
 */
public class ClienteService extends GenericService<Cliente> implements IClienteService {

	public ClienteService() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}


	
	/*
	 * private IClienteDao clienteDao;
	 * 
	 * public ClienteService(IClienteDao dao) { this.clienteDao = dao; }
	 * 
	 * @Override public Boolean salvar(Cliente cliente) throws
	 * TipoChavenaoEncontradaException { return clienteDao.cadastrar(cliente);
	 * 
	 * }
	 * 
	 * @Override public Cliente buscarporCpf(Long cpf) {
	 * 
	 * return clienteDao.consultar(cpf); }
	 * 
	 * @Override public void excluir(Long cpf) { clienteDao.excluir(cpf);
	 * 
	 * }
	 * 
	 * @Override public void alterar(Cliente cliente) throws
	 * TipoChavenaoEncontradaException { clienteDao.alterar(cliente);
	 * 
	 * }
	 */

}
