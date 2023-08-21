package br.com.ebac.ExercMod42Produto.Resource;

import br.com.ebac.ExercMod42Produto.Model.DTO.ProdutoDTO;
import br.com.ebac.ExercMod42Produto.Model.Produto;
import br.com.ebac.ExercMod42Produto.Service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(path = "")
    public ResponseEntity<Optional<List<Produto>>> todosProdutos(){
        try{
            Optional<List<Produto>> resposta = Optional.ofNullable(produtoService.findAll());
            if(resposta.isPresent()){
                return resposta.map(value -> ResponseEntity.ok().body(Optional.of(value))).orElseGet(()->ResponseEntity.noContent().build());
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Produto>> porId(@PathVariable("id") Long id){
        try{
            Optional<Produto> resposta = produtoService.findById(id);
            if(resposta.isPresent()){
                try{
                    Produto produto = new Produto(resposta.get().getId(),resposta.get().getNome(),resposta.get().getPreco(),resposta.get().getDescricao());
                    return ResponseEntity.ok().body(Optional.of(produto));
                }catch(EntityNotFoundException e){
                    return ResponseEntity.noContent().build();
                }
            }else{
                return ResponseEntity.noContent().build();
            }
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path="")
    public ResponseEntity<Optional<Produto>> salvar(@RequestBody ProdutoDTO produtoDTO){
        try{
            Optional<Produto>  resposta = Optional.ofNullable(produtoService.save(parseDTO(produtoDTO)));
            return resposta.map(value -> ResponseEntity.ok().body(Optional.of(value))).orElseGet(() -> ResponseEntity.noContent().build());
        }catch(NoSuchElementException e){
            return ResponseEntity.badRequest().build();
        }
    }

    public Produto parseDTO(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setDescricao(produtoDTO.getDescricao());
        return produto;
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Optional<Produto>> atualizar(@PathVariable Long id,@RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> resposta = produtoService.findById(id);
        if(resposta.isPresent()){
            try{
                resposta.get().setNome(produtoDTO.getNome());
                resposta.get().setPreco(produtoDTO.getPreco());
                resposta.get().setDescricao(produtoDTO.getDescricao());
                Optional<Produto> produto = Optional.ofNullable(produtoService.save(resposta.get()));
                return produto.map(value -> ResponseEntity.ok().body(Optional.of(value))).orElseGet(() -> ResponseEntity.noContent().build());
            }catch(EntityNotFoundException e){
                return ResponseEntity.noContent().build();
            }
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Produto>> delete(@PathVariable Long id){
        try{
            produtoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
