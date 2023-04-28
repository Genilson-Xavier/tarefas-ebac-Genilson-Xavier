package main;

import java.util.List;

import main.model.Contrato;

public interface IContratoService {

	boolean salvar();

	List<Contrato> buscar();

	void excluir();

	boolean atualizar(Contrato contrato);
	
	Contrato buscaporId(Long id);

}
