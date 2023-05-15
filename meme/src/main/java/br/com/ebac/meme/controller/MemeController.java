package br.com.ebac.meme.controller;

import br.com.ebac.meme.client.CategoriaMemeClient;
import br.com.ebac.meme.client.UsuarioMemeClient;
import br.com.ebac.meme.entity.Meme;
import br.com.ebac.meme.entity.vo.CategoriaVo;
import br.com.ebac.meme.entity.vo.MemeVo;
import br.com.ebac.meme.entity.vo.UsuarioVo;
import br.com.ebac.meme.service.MemeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/meme")
public class MemeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemeController.class);
	
    @Autowired
    private UsuarioMemeClient usuarioClient;

    @Autowired
    private CategoriaMemeClient categoriaClient;

    @Autowired
    private MemeService memeService;

    @PostMapping
    public Meme saveMeme(@RequestBody MemeVo memeVo){
        Object usuario = usuarioClient.usuarioPorNome(memeVo.getNomeUsuario());
        ObjectMapper mapper = new ObjectMapper();
        UsuarioVo usuarioVo = mapper.convertValue(usuario, UsuarioVo.class);
        Integer idUsuario = usuarioVo.getId();
        LOGGER.info(" id do serviço usuario {}", idUsuario);
        Object categoria = categoriaClient.categoriaPorNome(memeVo.getNomeCategoria());
        ObjectMapper mapper2 = new ObjectMapper();
        CategoriaVo categoriaVo = mapper2.convertValue(categoria, CategoriaVo.class);
        Integer idCategoria = categoriaVo.getId();
        LOGGER.info(" id do serviço categoria {}", idCategoria);

        return memeService.novoMeme(new MemeVo(memeVo.getNome(),memeVo.getUrl(),memeVo.getDescricao(),memeVo.getDataCadastro(),idUsuario,idCategoria));
    }

    @GetMapping
    private List<Meme> listaTodosMemes(){
        return memeService.listaTodosMemes();
    }

    @GetMapping("/dia")
    private Meme doDia(){
        return memeService.doDia();
    }
}
