package br.com.ebac.interfaces;

import br.com.ebac.entitys.Produto;

import java.util.List;
import java.util.Optional;

public interface IProdutoDao {
    public Integer cadastrar(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto buscar(Long id) throws Exception;

    public Optional<List<Produto>> buscarTodos() throws Exception;

    public Integer excluir(Produto produto) throws Exception;
}
