package br.com.ebac.usuario.controller;

import br.com.ebac.usuario.entity.Usuario;
import br.com.ebac.usuario.entity.vo.UsuarioVo;
import br.com.ebac.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    private UsuarioService usuarioService;

    private UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    private Usuario saveUsuario(@RequestBody UsuarioVo usuarioVo){
        return usuarioService.novoUsuario(usuarioVo);
    }

    // na chamada colocar ?nome=nome
    @GetMapping("/nome")
    private Usuario retornaPorNome(@RequestParam String nome){
        LOGGER.info(" nome do param Usuario {}", nome);
        return usuarioService.retornaPorNome(nome);
    }

    @GetMapping
    private List<Usuario> listaTodosUsuarios(){
        return usuarioService.listaTodosUsuarios();
    }

}
