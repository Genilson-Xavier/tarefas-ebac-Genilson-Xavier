package br.com.ebac.ExercMod42Produto.Service;

import br.com.ebac.ExercMod42Produto.Model.Produto;
import br.com.ebac.ExercMod42Produto.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> findById(Long id){
        return Optional.of(produtoRepository.getById(id));
    }
}
