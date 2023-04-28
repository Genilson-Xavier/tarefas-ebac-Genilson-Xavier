package main;

import java.util.List;

import main.model.Contrato;

public class ContratoService implements IContratoService {

	private IContratoDao contratoDao;
	
	public ContratoService(IContratoDao dao) {
		this.contratoDao = dao;
	}

	@Override
	public boolean salvar() {
		contratoDao.salvar();
		return true;
	}

	@Override
	public List<Contrato> buscar() {
		List<Contrato> contratos = contratoDao.buscar();
		return contratos;
	}

	@Override
	public void excluir() {
		contratoDao.excluir();
	}

	@Override
	public boolean atualizar(Contrato contrato) {
		Contrato contratoVerificado = buscaporId(contrato.getId());
		if(contratoVerificado != null) {
			contratoDao.atualizar(contrato);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Contrato buscaporId(Long id) {
		Contrato resposta = contratoDao.buscaPorid(id);
		return resposta;
	}

}
