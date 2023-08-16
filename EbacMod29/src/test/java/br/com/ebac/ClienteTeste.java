package br.com.ebac;

import br.com.ebac.Dao.ClienteDao;
import br.com.ebac.Factory.ConnectionFactory;
import br.com.ebac.entitys.Cliente;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;


public class ClienteTeste {
    private static final ClienteDao clienteDao = new ClienteDao();
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    Logger logger = Logger.getLogger(ClienteTeste.class.getName());

    @Test
    public void cadastrarTest() throws Exception{
        connectionFactory.connect();
        Cliente cliente = new Cliente();

        cliente.setNome("Teste1 Cadastro");

        cliente.setCodigo(geraHash("ASWQERTTR"));
        Integer qtd = clienteDao.cadastrar(cliente);

        assertEquals(1, (int) qtd);
    }

    @Test
    public void atualizartest() throws Exception {
        connectionFactory.connect();
        Cliente cliente = new Cliente();

        cliente.setNome("Teste1");

        cliente.setCodigo(geraHash("ASWQERTTR"));
        Integer qtd = clienteDao.atualizar(cliente);
        assertEquals(1, (int) qtd);
    }

    @Test
    public void buscarTest() throws Exception {
        connectionFactory.connect();
        Cliente resposta = clienteDao.buscar(geraHash("ASWQERTTR"));
        assertNotNull(resposta);
        assertNotNull(resposta.getId());
        logger.log(Level.INFO, " ID "+resposta.getId());
        assertEquals(geraHash("ASWQERTTR"), resposta.getCodigo());
        logger.log(Level.INFO," Codigo descriptografado "+voltaHash(resposta.getCodigo()));

    }

    @Test
    public void buscarTodosTest() throws Exception {

        connectionFactory.connect();
        Optional<List<Cliente>> clientes =  clienteDao.buscarTodos();
        clientes.get().stream().filter(e -> logarTodos(e.getId(),e.getCodigo(),e.getNome()));
        assertTrue(clientes.isPresent());

    }

    public boolean logarTodos(Long id, String codigo, String nome){
        logger.log(Level.INFO, " ID "+id);
        logger.log(Level.INFO," Codigo descriptografado "+voltaHash(codigo));
        logger.log(Level.INFO," Nome "+nome);
        return true;
    }

    @Test
    public void Excluirtest() throws Exception {
        connectionFactory.connect();
        Cliente resposta = clienteDao.buscar(geraHash("ASWQERTTR"));
        Integer qtd = clienteDao.excluir(resposta);
        assertNotNull(qtd);

    }
    public String geraHash(String texto){
        return Base64.encodeBase64String(texto.getBytes());
    }

    public String voltaHash(String texto){
        return new String(Base64.decodeBase64(texto.getBytes()));
    }
}
