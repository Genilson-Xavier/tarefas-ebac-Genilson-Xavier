package main;

import java.util.List;

import main.model.Contrato;

public class ContratoDao implements IContratoDao {

	@Override
	public boolean salvar() {
		throw new UnsupportedOperationException(" N�o funciona com o banco ");
	}

	@Override
	public List<Contrato> buscar() {
		throw new UnsupportedOperationException(" N�o funciona com o banco ");
	}

	@Override
	public void excluir() {
		throw new UnsupportedOperationException(" N�o funciona com o banco ");		
	}

	@Override
	public Contrato buscaPorid(Long id) {
		throw new UnsupportedOperationException(" N�o funciona com o banco ");	
	}

	@Override
	public void atualizar(Contrato contrato) {
		throw new UnsupportedOperationException(" N�o funciona com o banco ");		
	}

}
