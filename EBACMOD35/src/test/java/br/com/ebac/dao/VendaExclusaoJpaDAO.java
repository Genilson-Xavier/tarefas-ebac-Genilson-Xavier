package br.com.ebac.dao;

import br.com.ebac.dao.generic.jpa.GenericJpaDAO;
import br.com.ebac.dao.jpa.IVendaJpaDAO;
import br.com.ebac.domain.jpa.VendaJPA;
import br.com.ebac.exceptions.DAOException;
import br.com.ebac.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJPA, Long> implements IVendaJpaDAO {
    public VendaExclusaoJpaDAO() {
        super(VendaJPA.class);
    }

    @Override
    public void finalizarVenda(VendaJPA venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(VendaJPA venda) throws TipoChaveNaoEncontradaException, DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaJPA consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }
}
