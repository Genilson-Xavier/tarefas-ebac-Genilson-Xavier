package test.java.br.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dao.ClienteDaoMock;
import main.java.br.com.dao.IClienteDao;
import main.java.br.com.dao.exception.TipoChavenaoEncontradaException;
import main.java.br.com.domain.Cliente;

public class ClienteDaoTest {
	
	private IClienteDao clienteDao;
	
	private Cliente cliente;
	
	public ClienteDaoTest() {
		clienteDao = new ClienteDaoMock(); 
	}
	
	@Before
	public void init() throws TipoChavenaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12345678923l);
		cliente.setNome("Fulano");
		cliente.setCidade("SP");
		cliente.setEnd("rua teste");
		cliente.setEstado("SP");
		cliente.setNumero(12);
		cliente.setTel(999998888l);		
		
		clienteDao.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test 
	public void salvarCliente() throws TipoChavenaoEncontradaException {
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChavenaoEncontradaException {
		cliente.setNome("Fulano Beltrano");
		clienteDao.alterar(cliente);
		Assert.assertEquals("Fulano Beltrano", cliente.getNome());
	}
}
