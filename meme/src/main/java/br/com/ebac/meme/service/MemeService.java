package br.com.ebac.meme.service;

import br.com.ebac.meme.entity.Meme;
import br.com.ebac.meme.entity.vo.MemeVo;
import br.com.ebac.meme.repository.MemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemeService {
    private MemeRepository memeRepository;

    private MemeService(MemeRepository memeRepository){
        this.memeRepository = memeRepository;
    }

    public Meme novoMeme(MemeVo memeVo){
        return memeRepository.save(new Meme(memeVo.getNome(),memeVo.getUrl(),memeVo.getDescricao(),memeVo.getDataCadastro(),memeVo.getIdUsuario(),memeVo.getIdCategoria()));
    }

    public List<Meme> listaTodosMemes(){
        return memeRepository.findAll();
    }

    public Meme doDia(){
        return memeRepository.findDia();
    }
}
