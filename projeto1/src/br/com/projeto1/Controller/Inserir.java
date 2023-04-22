package br.com.projeto1.Controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.projeto1.Dao.IClienteDao;
//import br.com.projeto1.Dao.ClienteMapDao;
//import br.com.projeto1.Dao.IClienteDao;
import br.com.projeto1.Model.Cliente;
import br.com.projeto1.Service.Service;

public class Inserir extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTel;
	private JTextField txtEnd;
	private JTextField txtNum;
	private JTextField txtCidade;
	private JTextField txtEst;
	static JFrame f;
	//private static IClienteDao iClienteDao;
	

	
	public void InsertDialog(IClienteDao iClienteDao) {
		//iClienteDao = new ClienteMapDao();
		Service service = new Service();
		setTitle("Adicionar Cliente");
		//setBounds(100, 100, 350, 200);
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(new BorderLayout());
		try {
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getContentPane().add(contentPanel, BorderLayout.CENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			contentPanel.setLayout(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtNome = new JTextField();
		txtNome.setBounds(115, 11, 160, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(40);

		txtCpf = new JTextField();
		txtCpf.setBounds(115, 39, 160, 20);
		contentPanel.add(txtCpf);
		txtCpf.setColumns(40);
		
		txtTel = new JTextField();
		txtTel.setBounds(115, 67, 160, 20);
		contentPanel.add(txtTel);
		txtTel.setColumns(40);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(115, 95, 160, 20);
		contentPanel.add(txtEnd);
		txtEnd.setColumns(40);
		
		txtNum = new JTextField();
		txtNum.setBounds(115, 123, 160, 20);
		contentPanel.add(txtNum);
		txtNum.setColumns(40);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(115, 151, 160, 20);
		contentPanel.add(txtCidade);
		txtCidade.setColumns(40);
		
		txtEst = new JTextField();
		txtEst.setBounds(115, 179, 160, 20);
		contentPanel.add(txtEst);
		txtEst.setColumns(40);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 42, 46, 14);
		contentPanel.add(lblCpf);
		
		JLabel lblTel = new JLabel("Telefone");
		lblTel.setBounds(10, 70, 66, 14);
		contentPanel.add(lblTel);
		
		JLabel lblEnd = new JLabel("Endereco");
		lblEnd.setBounds(10, 98, 66, 14);
		contentPanel.add(lblEnd);
		
		JLabel lblNum = new JLabel("Numero");
		lblNum.setBounds(10, 126, 46, 14);
		contentPanel.add(lblNum);
		
		JLabel lblCid = new JLabel("Cidade");
		lblCid.setBounds(10, 154, 46, 14);
		contentPanel.add(lblCid);
		
		JLabel lblEst = new JLabel("Estado");
		lblEst.setBounds(10, 182, 46, 14);
		contentPanel.add(lblEst);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						temConteudo(txtNome.getText(),"Nome");
						temConteudo(txtCpf.getText(),"CPF");
						temConteudo(txtTel.getText(),"Telefone");
						temConteudo(txtEnd.getText(),"Endereco");
						temConteudo(txtNum.getText(),"Numero");
						temConteudo(txtCidade.getText(),"Cidade");
						temConteudo(txtEst.getText(),"Estado");
						Cliente cliente = new Cliente(txtNome.getText(),Long.parseLong(txtCpf.getText()),Long.parseLong(txtTel.getText()),txtEnd.getText(),Integer.parseInt(txtNum.getText()),txtCidade.getText(),txtEst.getText());
						//System.out.println(cliente.toString());
						Boolean cadastrado = service.cadastrar(cliente, iClienteDao);
						if(cadastrado) {
							JOptionPane.showMessageDialog(null,"Cliente cadastrado com Sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Cliente já cadastrado","Erro",JOptionPane.ERROR_MESSAGE);
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void temConteudo(String conteudo, String campo) {
		if(conteudo.isBlank() || conteudo.isEmpty()) {
			 f = new JFrame("frame");
		     // create a dialog Box
	         JDialog d = new JDialog(f, "Mensagem");
	
	         // create a label
	         JLabel l = new JLabel("Sem Valor no "+campo);
	
	         d.add(l);
	
	         // setsize of dialog
	         d.setSize(100, 100);
	
	         // set visibility of dialog
	         d.setVisible(true);
	         
	         // Centraliza
	         d.setLocationRelativeTo(null);
		}
	}
	
	/*
	 * private Boolean cadastrar(Cliente cliente) { Boolean isCadastrado =
	 * iClienteDao.cadastrar(cliente); return isCadastrado; }
	 */
}
