/**
 * 
 */
package main.java.br.com.dao.generics;

import java.util.Collection;

import main.java.br.com.dao.exception.TipoChavenaoEncontradaException;
import main.java.br.com.domain.Persistente;

/**
 * @author Genilson Xavier
 *
 */
public interface IGenericService<T extends Persistente> {
	
	public Boolean cadastrar(T entity) throws TipoChavenaoEncontradaException;
	
	public void excluir(Long valor);
		
	public void alterar(T entity) throws TipoChavenaoEncontradaException;
	
	public T consultar(Long valor);
	
	public Collection<T> buscarTodos();
}
