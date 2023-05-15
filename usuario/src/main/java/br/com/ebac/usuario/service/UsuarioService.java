package br.com.ebac.usuario.service;

import br.com.ebac.usuario.entity.Usuario;
import br.com.ebac.usuario.entity.vo.UsuarioVo;
import br.com.ebac.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /*private UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }*/

    public Usuario novoUsuario(UsuarioVo usuarioVo){
        return usuarioRepository.save(new Usuario(usuarioVo.getNome(),usuarioVo.getEmail(),usuarioVo.getDataCadastro()));
    }

    public List<Usuario> listaTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario retornaPorNome(String nome){
        return usuarioRepository.findPorNome(nome);
    }
}
