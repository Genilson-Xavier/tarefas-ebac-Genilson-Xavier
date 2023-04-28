package main;

import java.util.List;

import main.model.Contrato;

public interface IContratoDao {

	boolean salvar();

	List<Contrato> buscar();

	void excluir();

	Contrato buscaPorid(Long id);

	void atualizar(Contrato contrato);

}
