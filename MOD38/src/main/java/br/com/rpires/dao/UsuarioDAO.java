package br.com.rpires.dao;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Long> implements IUsuarioDAO{

	public UsuarioDAO() {
		super(Usuario.class);
	}

}
