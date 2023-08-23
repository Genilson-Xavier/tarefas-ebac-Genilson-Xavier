package br.com.ebac.dao.jpa;

import br.com.ebac.dao.generic.jpa.GenericJpaDAO;
import br.com.ebac.domain.jpa.ClienteJPA;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJPA, Long> implements IClienteJpaDAO{
    public ClienteJpaDAO() {
        super(ClienteJPA.class);
    }
}
