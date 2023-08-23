/**
 * 
 */
package br.com.ebac.dao;


import br.com.ebac.dao.generic.IGenericDAO;
import br.com.ebac.domain.Venda;
import br.com.ebac.exceptions.DAOException;
import br.com.ebac.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
