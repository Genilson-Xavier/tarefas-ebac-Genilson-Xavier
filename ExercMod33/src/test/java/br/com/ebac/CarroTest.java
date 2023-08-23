package br.com.ebac;

import br.com.ebac.dao.*;
import br.com.ebac.domain.Acessorio;
import br.com.ebac.domain.Carro;
import br.com.ebac.domain.Marca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarroTest {
    private ICarroDAO carroDAO;

    private IMarcaDAO marcaDAO;

    private IAcessorioDAO acessorioDAO;

    @Before
    public void setUp() throws Exception {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
    }

    @Test
    public void salvarCarro() {

        Carro carro = new Carro();
        carro.setNome("UNO");
        carro.setPlaca("123456789");
        Carro retorno = carroDAO.cadastrar(carro);
        Assert.assertNotNull(retorno);
        Assert.assertNotNull(retorno.getId());

        Marca marca = criaMarca(carro);
        Assert.assertNotNull(marca);
        Assert.assertNotNull(marca.getId());

    }

    private Marca criaMarca(Carro carro) {
        Marca marca = new Marca();
        marca.setNome("Fiat");
        marca.setCarro(carro);
        return marcaDAO.cadastrar(marca);
    }

    @Test
    public void salvarAcessorio(){
        Carro carro = carroDAO.buscar(1L);
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Farol");
        acessorio.setDescricao(" Farol do UNO");
        acessorio.setCarro(carro);
        acessorioDAO.cadastrar(acessorio);
    }

    @Test
    public void buscarAcessorioPorCarro(){
        Carro carro = carroDAO.buscar(1L);
        List<Acessorio> acessorios = acessorioDAO.listarPorCarro(carro);
        Assert.assertNotNull(acessorios);
        Assert.assertEquals(1, acessorios.size());
    }

}
