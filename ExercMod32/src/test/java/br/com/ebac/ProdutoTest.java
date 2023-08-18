package br.com.ebac;

import br.com.ebac.dao.IProdutoDao;
import br.com.ebac.dao.ProdutoDao;
import br.com.ebac.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProdutoTest {
    private IProdutoDao produtoDao;

    ProdutoTest(){
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar(){
        Produto produto = new Produto();
        produto.setNome("Lapis");
        produto.setCodigo("A14");

        Produto retorno = produtoDao.cadastrar(produto);

        assertNotNull(retorno);
        assertNotNull(retorno.getId());
    }
}
