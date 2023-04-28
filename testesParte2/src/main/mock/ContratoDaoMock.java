package main.mock;

import java.util.ArrayList;
import java.util.List;

import main.IContratoDao;
import main.model.Contrato;

public class ContratoDaoMock implements IContratoDao {

	@Override
	public boolean salvar() {
		return true;
	}

	@Override
	public List<Contrato> buscar() {
		List<Contrato> contratos = new ArrayList<Contrato>();
		contratos.add(new Contrato(1l, "Vult SA",18695885000156l));
		contratos.add(new Contrato(2l, "Empiricus Ltda",96719326000142l));
		return contratos;
	}

	@Override
	public void excluir() {
		
	}

	@Override
	public Contrato buscaPorid(Long id) {		
		return new Contrato(id,"Test Ltda",96719326000142l);
	}

	@Override
	public void atualizar(Contrato contrato) {
		new Contrato(contrato.getId(),contrato.getNomeContratante(),contrato.getCnpj());		
	}

}
