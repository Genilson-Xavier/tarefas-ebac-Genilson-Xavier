package br.com.ebac.interfaces;

import br.com.ebac.entitys.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDao {
    public Integer cadastrar(Cliente cliente) throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;

    public Cliente buscar(String codigo) throws Exception;

    public Optional<List<Cliente>> buscarTodos() throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;
}
