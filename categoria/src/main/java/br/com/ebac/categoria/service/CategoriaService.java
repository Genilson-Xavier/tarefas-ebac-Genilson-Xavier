package br.com.ebac.categoria.service;

import br.com.ebac.categoria.entity.Categoria;
import br.com.ebac.categoria.repository.CategoriaRepository;
import br.com.ebac.categoria.vo.CategoriaVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    private CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria novaCategoria(CategoriaVo categoriaVo){
        return categoriaRepository.save(new Categoria(categoriaVo.getNome(),categoriaVo.getDescricao(),categoriaVo.getDataCadastro(),categoriaVo.getIdUsuario()));
    }

    public List<Categoria> listaTodasCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria findPorNome(String nome){ return categoriaRepository.findPorNome(nome); }
}
