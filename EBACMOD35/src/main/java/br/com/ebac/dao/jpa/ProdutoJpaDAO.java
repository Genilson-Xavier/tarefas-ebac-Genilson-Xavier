package br.com.ebac.dao.jpa;

import br.com.ebac.dao.generic.jpa.GenericJpaDAO;
import br.com.ebac.domain.jpa.ProdutoJPA;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJPA, Long> implements IProdutoJpaDAO{
    public ProdutoJpaDAO() {
        super(ProdutoJPA.class);
    }

}
