package br.com.rpires.service;

import br.com.rpires.domain.Usuario;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.services.generic.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario,Long>{
	Usuario buscarPorCPF(Long cpf) throws DAOException;
	boolean login(String cpf, String senha);
}
