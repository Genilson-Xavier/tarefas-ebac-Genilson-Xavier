/**
 * 
 */
package br.com.ebac.services;


import br.com.ebac.dao.IProdutoDAO;
import br.com.ebac.domain.Produto;
import br.com.ebac.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
