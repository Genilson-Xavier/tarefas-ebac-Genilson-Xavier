/**
 * 
 */
package test.java.br.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dao.exception.TipoChavenaoEncontradaException;
import main.java.br.com.domain.Cliente;
import main.java.br.com.services.IProdutoService;
import main.java.br.com.services.ProdutoServiceMock;

/**
 * @author Genilson Xavier
 *
 */
public class ProdutoServiceTest {
	
	private IProdutoService produtoService;
	
	private Cliente cliente;
	
	public ProdutoServiceTest() {
		produtoService = new ProdutoServiceMock();
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
		
		produtoService.cadastrar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado = produtoService.consultar(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test 
	public void salvarCliente() throws TipoChavenaoEncontradaException {
		Boolean retorno = produtoService.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}
	
	
	@Test
	public void excluirCliente() {
		produtoService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChavenaoEncontradaException {
		cliente.setNome("Fulano Beltrano");
		produtoService.alterar(cliente);
		Assert.assertEquals("Fulano Beltrano", cliente.getNome());
	}
}
