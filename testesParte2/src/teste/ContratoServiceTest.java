/**
 * 
 */
package teste;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.ContratoDao;
import main.ContratoService;
import main.IContratoService;
import main.mock.ContratoDaoMock;
import main.model.Contrato;

public class ContratoServiceTest {
	
	IContratoService service = new ContratoService(new ContratoDao());
	IContratoService serviceMock = new ContratoService(new ContratoDaoMock());
	
	@Test
	public void salvarTest() {
		
		// troquei para boolean pois a validação se inseriu ou não seria mais viavel 
		boolean retorno = serviceMock.salvar();
		Assert.assertEquals(true, retorno);	
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void esperadoErroNoSalvarComBancoTest() {
		
		// troquei para boolean pois a validação se inseriu ou não seria mais viavel 
		boolean retorno = service.salvar();
		Assert.assertEquals(true, retorno);	
	}
	
	@Test
	public void buscarTest() {
		
		List<Contrato> contratos = serviceMock.buscar();
		boolean quantidadeDeContratos = contratos.size() > 0;
		Assert.assertEquals(true, quantidadeDeContratos);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void esperadoErroNaBuscaComBancoTest() {
		
		List<Contrato> contratos = service.buscar();
		boolean quantidadeDeContratos = contratos.size() > 0;
		Assert.assertEquals(true, quantidadeDeContratos);
	}
	
	@Test
	public void excluirTest() {
		
		serviceMock.excluir();
		Assert.assertEquals(1,1);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void esperadoErroNaExclusaoComBancoTest() {
		
		service.excluir();
		Assert.assertEquals(1,1);
	}
	
	@Test
	public void atualizarTest() {
		
		Contrato contrato = new Contrato();
		boolean retorno = serviceMock.atualizar(contrato);
		Assert.assertEquals(true,retorno);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void esperadoErroAoAtualizarComBancoTest() {
		
		Contrato contrato = new Contrato();
		boolean retorno = service.atualizar(contrato);
		Assert.assertEquals(true,retorno);
	}
}
