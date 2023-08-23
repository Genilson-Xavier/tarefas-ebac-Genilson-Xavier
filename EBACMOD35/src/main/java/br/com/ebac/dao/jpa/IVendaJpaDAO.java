package br.com.ebac.dao.jpa;

import br.com.ebac.dao.generic.jpa.IGenericJpaDAO;
import br.com.ebac.domain.jpa.VendaJPA;
import br.com.ebac.exceptions.DAOException;
import br.com.ebac.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJPA, Long> {
    public void finalizarVenda(VendaJPA venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaJPA venda) throws TipoChaveNaoEncontradaException, DAOException;
    public VendaJPA consultarComCollection(Long id);
}
