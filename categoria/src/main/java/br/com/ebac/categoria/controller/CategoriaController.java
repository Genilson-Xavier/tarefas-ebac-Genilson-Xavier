package br.com.ebac.categoria.controller;

import br.com.ebac.categoria.client.UsuarioClient;
import br.com.ebac.categoria.entity.Categoria;
import br.com.ebac.categoria.entity.vo.UsuarioVo;
import br.com.ebac.categoria.service.CategoriaService;
import br.com.ebac.categoria.vo.CategoriaVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria saveCategoria(@RequestBody CategoriaVo categoriaVo) throws IllegalAccessException {
        Object resposta = usuarioClient.usuarioPorNome(categoriaVo.getNomeUsuario());
        ObjectMapper mapper = new ObjectMapper();
        UsuarioVo usuario = mapper.convertValue(resposta, UsuarioVo.class);
        Integer idUsuario = usuario.getId();
        LOGGER.info(" id do serviço usuario {}", idUsuario);
        return categoriaService.novaCategoria(new CategoriaVo(categoriaVo.getNome(),categoriaVo.getDescricao(),categoriaVo.getDataCadastro(),idUsuario));
    }

    @GetMapping
    private List<Categoria> listaTodasCategorias(){
        return categoriaService.listaTodasCategorias();
    }

    // na chamada colocar ?nome=nome
    @GetMapping("/nome")
    private Categoria retornaPorNome(@RequestParam String nome){
        LOGGER.info(" nome do param Categoria {}", nome);
        return categoriaService.findPorNome(nome);
    }
}
