package br.com.projeto1.Controller;

import javax.swing.JOptionPane;

import br.com.projeto1.Dao.ClienteMapDao;
import br.com.projeto1.Dao.IClienteDao;
import br.com.projeto1.Model.Cliente;

public class App {
	
	private static IClienteDao iClienteDao;
	
	public static void main(String[] args) {

		iClienteDao = new ClienteMapDao();
		String opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para Sair","Menu",JOptionPane.INFORMATION_MESSAGE); 
		while(!isOpcaoValida(opcao)) {
			if("".equals(opcao)) {
				sair();
			}
			opcao = JOptionPane.showInputDialog(null,"Opção inválida Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para Sair","Menu",JOptionPane.INFORMATION_MESSAGE);
		}
		String dados ="";
		while(isOpcaoValida(opcao)) {
			switch(opcao) {
				case "5":
					sair();
					break;
				case "1":
					dados = JOptionPane.showInputDialog(null,"Digite os daddos do Cliente separado por virgula, conforme exemplo:  Nome, CPF, Telefone, endereco, numero, cidade, estado ","Cadastro",JOptionPane.INFORMATION_MESSAGE);
					cadastrar(dados);
					break;
				case "2":
					dados = JOptionPane.showInputDialog(null,"Digite o CPF ","Consulta",JOptionPane.INFORMATION_MESSAGE);
					consultar(dados);
					break;	
				case "3":
					dados = JOptionPane.showInputDialog(null,"Digite o CPF ","Consulta",JOptionPane.INFORMATION_MESSAGE);
					excluir(dados);
					break;	
				case "4":
					dados = JOptionPane.showInputDialog(null,"Digite os daddos do Cliente separado por virgula, conforme exemplo:  Nome, CPF, Telefone, endereco, numero, cidade, estado  ","Alteracao",JOptionPane.INFORMATION_MESSAGE);
					alterar(dados);
					break;					
			}
			opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para Sair","Menu",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void alterar(String dados) {
		String d0 ="null";
		String d1 ="0";
		String d2 ="0";
		String d3 ="null";
		String d4 ="0";
		String d5 ="null";
		String d6 ="null";
		
		String[] dadosSeparados = dados.split(",");

		for(int y=0; y<dadosSeparados.length;y++) {
			if(!dadosSeparados[y].isBlank() && !dadosSeparados[y].isEmpty()) {
				switch(y) {
				case 0:
					d0 = dadosSeparados[y];
					break;
				case 1:
					d1 = dadosSeparados[y];
					break;
				case 2:
					d2 = dadosSeparados[y];
					break;
				case 3:
					d3 = dadosSeparados[y];
					break;
				case 4:
					d4 = dadosSeparados[y];
					break;
				case 5:
					d5 = dadosSeparados[y];
					break;
				case 6:
					d6 = dadosSeparados[y];
					break;					
				}
			}
		}
		Cliente cliente = new Cliente(d0,Long.parseLong(d1),Long.parseLong(d2),d3,Integer.parseInt(d4),d5,d6);
		if(cliente != null) {
			iClienteDao.alterar(cliente);
			JOptionPane.showMessageDialog(null,"Cliente Alterado "+cliente.toString(),"Sucesso",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void excluir(String dados) {
		iClienteDao.excluir(Long.parseLong(dados));
		JOptionPane.showMessageDialog(null,"Cliente Excluido ","Exclusao",JOptionPane.INFORMATION_MESSAGE);
	}

	private static void consultar(String dados) {
		Cliente cliente = iClienteDao.consultar(Long.parseLong(dados));
		if(cliente != null) {
			JOptionPane.showMessageDialog(null,"Cliente encontrado: "+cliente.toString(),"Consulta",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null,"Cliente não encontrado: ","Consulta",JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void cadastrar(String dados) {
		String d0 ="null";
		String d1 ="0";
		String d2 ="0";
		String d3 ="null";
		String d4 ="0";
		String d5 ="null";
		String d6 ="null";
		
		String[] dadosSeparados = dados.split(",");

		for(int y=0; y<dadosSeparados.length;y++) {
			if(!dadosSeparados[y].isBlank() && !dadosSeparados[y].isEmpty()) {
				switch(y) {
				case 0:
					d0 = dadosSeparados[y];
					break;
				case 1:
					d1 = dadosSeparados[y];
					break;
				case 2:
					d2 = dadosSeparados[y];
					break;
				case 3:
					d3 = dadosSeparados[y];
					break;
				case 4:
					d4 = dadosSeparados[y];
					break;
				case 5:
					d5 = dadosSeparados[y];
					break;
				case 6:
					d6 = dadosSeparados[y];
					break;					
				}
			}
		}
		Cliente cliente = new Cliente(d0,Long.parseLong(d1),Long.parseLong(d2),d3,Integer.parseInt(d4),d5,d6);
		Boolean isCadastrado = iClienteDao.cadastrar(cliente);
		if(isCadastrado) {
			JOptionPane.showMessageDialog(null,"Cliente cadastrado com Sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null,"Cliente já cadastrado","Erro",JOptionPane.ERROR_MESSAGE);
			
		}
	}

	private static void sair() {
		JOptionPane.showMessageDialog(null,"Saindo","Sair",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	private static boolean isOpcaoValida(String opcao) {
		switch(opcao) {
			case "1":
				return true;
			case "2":
				return true;
			case "3":
				return true;
			case "4":
				return true;
			case "5":
				return true;
			default:
				return false;
		}
	}
	
}
