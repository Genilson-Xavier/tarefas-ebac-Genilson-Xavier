/**
 * 
 */
package main.java.br.com.dao;

import main.java.br.com.dao.generics.GenericDao;
import main.java.br.com.domain.Cliente;

/**
 * @author Genilson Xavier
 *
 */
public class ClienteDao extends GenericDao<Cliente> implements IClienteDao{

	public ClienteDao() {
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


}
