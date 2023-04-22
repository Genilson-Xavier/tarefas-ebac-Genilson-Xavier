package br.com.projeto1.Controller;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.projeto1.Model.Cliente;

public class Consultar extends JDialog{

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
	
	public void ConsultDialog(Cliente cliente) {
		
		setTitle("Consultar Cliente");
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
		txtNome.setText(cliente.getNome());
		txtNome.setEditable(false);

		txtCpf = new JTextField();
		txtCpf.setBounds(115, 39, 160, 20);
		contentPanel.add(txtCpf);
		txtCpf.setColumns(40);
		txtCpf.setText(cliente.getCpf().toString());
		txtCpf.setEditable(false);
		
		txtTel = new JTextField();
		txtTel.setBounds(115, 67, 160, 20);
		contentPanel.add(txtTel);
		txtTel.setColumns(40);
		txtTel.setText(cliente.getTelefone().toString());
		txtTel.setEditable(false);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(115, 95, 160, 20);
		contentPanel.add(txtEnd);
		txtEnd.setColumns(40);
		txtEnd.setText(cliente.getEndereco());
		txtEnd.setEditable(false);
		
		txtNum = new JTextField();
		txtNum.setBounds(115, 123, 160, 20);
		contentPanel.add(txtNum);
		txtNum.setColumns(40);
		txtNum.setText(cliente.getNumero().toString());
		txtNum.setEditable(false);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(115, 151, 160, 20);
		contentPanel.add(txtCidade);
		txtCidade.setColumns(40);
		txtCidade.setText(cliente.getCidade());
		txtCidade.setEditable(false);
		
		txtEst = new JTextField();
		txtEst.setBounds(115, 179, 160, 20);
		contentPanel.add(txtEst);
		txtEst.setColumns(40);
		txtEst.setText(cliente.getEstado());
		txtEst.setEditable(false);
		
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
	}
}
