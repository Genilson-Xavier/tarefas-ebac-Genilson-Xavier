package br.com.ebac.Dao;

import br.com.ebac.Factory.ConnectionFactory;
import br.com.ebac.entitys.Cliente;
import br.com.ebac.entitys.Produto;
import br.com.ebac.interfaces.IProdutoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDao implements IProdutoDao {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = connectionFactory.connect();
            String sql = "INSERT INTO TB_PRODUTO (ID, NOME, PRECO) VALUES (nextval('SQ_PRODUTO'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setBigDecimal(2, produto.getPreco());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        if (produto == null) {
            throw new Exception("Produto nulo");
        }

        try {
            connection = connectionFactory.connect();
            String sql = "UPDATE TB_PRODUTO SET NOME=?, PRECO=? WHERE ID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setBigDecimal(2, produto.getPreco());
            stm.setLong(3, produto.getId());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }
    }

    @Override
    public Produto buscar(Long id) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = connectionFactory.connect();
            String sql = "select * from TB_PRODUTO where ID = ?";
            stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setPreco(rs.getBigDecimal("PRECO"));

            }
            return produto;
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Optional<List<Produto>> buscarTodos() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = connectionFactory.connect();
            String sql = "select * from TB_PRODUTO";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setPreco(rs.getBigDecimal("PRECO"));
                produtos.add(produto);
            }
            return Optional.of(produtos);
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = connectionFactory.connect();
            String sql = "DELETE FROM TB_PRODUTO WHERE ID = ?";
            stm = connection.prepareStatement(sql);
            stm.setLong(1, produto.getId());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
