package br.com.rpires.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rpires.domain.Usuario;
import br.com.rpires.service.IUsuarioService;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	@Inject
	transient private IUsuarioService usuarioService;
	
	@PostConstruct
    public void init() {
		try {
			this.usuario = new Usuario();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o usuario"));
		}
	}
	
	public void add() {
		try {
			usuarioService.cadastrar(usuario);
			this.usuario = new Usuario();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o usuario"));
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
