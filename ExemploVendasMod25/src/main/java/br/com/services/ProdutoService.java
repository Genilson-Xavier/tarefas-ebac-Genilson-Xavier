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
public class ProdutoService extends GenericService<Cliente> implements IProdutoService{
	
	public ProdutoService() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
		// TODO Auto-generated method stub
		
	}
	
}
