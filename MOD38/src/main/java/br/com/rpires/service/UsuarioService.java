package br.com.rpires.service;

import java.util.Collection;
import javax.inject.Inject;

import br.com.rpires.dao.IUsuarioDAO;
import br.com.rpires.domain.Usuario;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.services.generic.GenericService;

public class UsuarioService extends GenericService<Usuario, Long> implements IUsuarioService{

	@Inject
	public UsuarioService(IUsuarioDAO dao) {
		super(dao);
	}
	
	@Override
	public Usuario buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(String cpf, String senha) {
		try {
			Collection<Usuario> usuarios = this.dao.buscarTodos();
			//usuarios.stream().map(e->checaLogin(e.getCpf(), e.getSenha(), cpf, senha));
		     boolean resposta = false; 
		    		 if(usuarios.stream().filter(e -> checaLogin(e.getCpf(), e.getSenha(), cpf, senha) == true).findFirst().orElse(null) != null) { resposta =true; }
			//return this.dao.consultar(Long.parseLong(cpf)) != null;
		    		 return resposta;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return false; 
	}

	private boolean checaLogin(Long cpf, String senha, String cpfPassado, String senhaPassada) {
		if(cpf == Long.parseLong(cpfPassado) && senha == senhaPassada) {
			return true;
		}
		return false;
	}
}
