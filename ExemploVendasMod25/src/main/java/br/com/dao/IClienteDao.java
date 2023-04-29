package main.java.br.com.dao;

import main.java.br.com.dao.generics.IGenericDao;
import main.java.br.com.domain.Cliente;

/**
 * @author Genilson Xavier
 *
 */
public interface IClienteDao extends IGenericDao<Cliente>{

	/*
	 * Boolean salvar(Cliente cliente);
	 * 
	 * Cliente buscarporCpf(Long cpf);
	 * 
	 * void excluir(Long cpf);
	 * 
	 * void alterar(Cliente cliente) throws TipoChavenaoEncontradaException;
	 */
}
