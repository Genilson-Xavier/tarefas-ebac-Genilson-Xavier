/**
 * 
 */
package test.java.br.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dao.exception.TipoChavenaoEncontradaException;
import main.java.br.com.domain.Cliente;
import main.java.br.com.services.ClienteServiceMock;
import main.java.br.com.services.IClienteService;

/**
 * @author Genilson Xavier
 *
 */
public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		//IClienteDao dao = new ClienteDaoMock();
		clienteService = new ClienteServiceMock();//new ClienteService(dao);
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
		
		clienteService.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test 
	public void salvarCliente() throws TipoChavenaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChavenaoEncontradaException {
		cliente.setNome("Fulano Beltrano");
		clienteService.alterar(cliente);
		Assert.assertEquals("Fulano Beltrano", cliente.getNome());
	}
}
