package br.com.projeto1.Service;


import br.com.projeto1.Dao.IClienteDao;
import br.com.projeto1.Model.Cliente;

public class Service {
	//private static IClienteDao iClienteDao;
	
	
	public Boolean cadastrar(Cliente cliente, IClienteDao iClienteDao) {
		Boolean isCadastrado = iClienteDao.cadastrar(cliente);
		return isCadastrado;
	}
	
	public Cliente consultar(String dados, IClienteDao iClienteDao) {
		Cliente cliente = iClienteDao.consultar(Long.parseLong(dados));
		if(cliente != null) {
			return cliente;
		}else {
			return null;
		}
	}
	
	public void alterar(Cliente cliente, IClienteDao iClienteDao) {
		iClienteDao.alterar(cliente);
	}
	
	public void excluir(String cpf, IClienteDao iClienteDao) {
		iClienteDao.excluir(Long.parseLong(cpf));
	}
}
