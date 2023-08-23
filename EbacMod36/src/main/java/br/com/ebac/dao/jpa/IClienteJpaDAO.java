/**
 * 
 */
package br.com.ebac.dao.jpa;

import br.com.ebac.dao.generic.jpa.IGenericJapDAO;
import br.com.ebac.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
