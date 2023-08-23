/**
 * 
 */
package br.com.ebac.dao.jpa;

import br.com.ebac.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.ebac.domain.jpa.ClienteJpa;


public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
