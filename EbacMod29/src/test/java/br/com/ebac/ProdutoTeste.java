package br.com.ebac;

import br.com.ebac.Dao.ProdutoDao;
import br.com.ebac.Factory.ConnectionFactory;
import br.com.ebac.entitys.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ProdutoTeste {
    private static final ProdutoDao produtoDao = new ProdutoDao();
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    Logger logger = Logger.getLogger(ProdutoTeste.class.getName());

    @Test
    public void cadastrarTest() throws Exception{
        connectionFactory.connect();
        Produto produto = new Produto();
        produto.setNome("Lapis");
        produto.setPreco(new BigDecimal("1.49"));
        Integer qtd = produtoDao.cadastrar(produto);

        assertEquals(1, (int) qtd);

    }

    @Test
    public void atualizartest() throws Exception {
        connectionFactory.connect();
        Produto produto = produtoDao.buscar(1L);
        produto.setPreco(new BigDecimal("1.72"));
        Integer qtd = produtoDao.atualizar(produto);

        assertEquals(1, (int) qtd);
    }

    @Test
    public void buscarTest() throws Exception {
        connectionFactory.connect();
        Produto produto = produtoDao.buscar(1L);
        assertNotNull(produto);
        assertNotNull(produto.getId());
        logger.log(Level.INFO, " ID "+produto.getId());

    }

    @Test
    public void buscarTodosTest() throws Exception {
        connectionFactory.connect();
        Optional<List<Produto>> produtos =  produtoDao.buscarTodos();

        assertTrue(produtos.isPresent());
    }

    @Test
    public void Excluirtest() throws Exception {
        connectionFactory.connect();
        Produto produto = produtoDao.buscar(1L);
        if(produto != null) {
            Integer qtd = produtoDao.excluir(produto);

            assertEquals(1, (int) qtd);
        }else{
            logger.log(Level.INFO,"Produto não encontrado");
        }

    }
}
