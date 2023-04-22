package br.com.projeto1.Controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.projeto1.Dao.ClienteMapDao;
import br.com.projeto1.Dao.IClienteDao;
import br.com.projeto1.Model.Cliente;
import br.com.projeto1.Service.Service;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static IClienteDao iClienteDao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setTitle("Menu Cliente");
					frame.setLocationRelativeTo(null); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainFrame() {
		iClienteDao = new ClienteMapDao();
		Service service = new Service();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
							Inserir front = new Inserir();
							front.InsertDialog(iClienteDao);
							front.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							front.setLocationRelativeTo(null);
							front.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAdicionar.setBounds(36, 23, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
								String dados = JOptionPane.showInputDialog(null,"Digite o CPF ","Consulta",JOptionPane.INFORMATION_MESSAGE);
								Cliente cliente = service.consultar(dados, iClienteDao);
								if(cliente != null) {
									Consultar cons = new Consultar();
									cons.ConsultDialog(cliente);
									cons.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									cons.setLocationRelativeTo(null);
									cons.setVisible(true);
								}else {
									JOptionPane.showMessageDialog(null,"Cliente não encontrado: ","Consulta",JOptionPane.ERROR_MESSAGE);
								}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConsulta.setBounds(135, 23, 89, 23);
		contentPane.add(btnConsulta);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
								String dados = JOptionPane.showInputDialog(null,"Digite o CPF ","Consulta",JOptionPane.INFORMATION_MESSAGE);
								Cliente cliente = service.consultar(dados, iClienteDao);
								if(cliente != null) {
									Alterar alter = new Alterar();
									alter.AlterDialog(cliente, iClienteDao);
									alter.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									alter.setLocationRelativeTo(null);
									alter.setVisible(true);
								}else {
									JOptionPane.showMessageDialog(null,"Cliente não encontrado ","Consulta",JOptionPane.ERROR_MESSAGE);
								}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAlterar.setBounds(36, 57, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
								String dados = JOptionPane.showInputDialog(null,"Digite o CPF ","Consulta",JOptionPane.INFORMATION_MESSAGE);
								Cliente cliente = service.consultar(dados, iClienteDao);
								if(cliente != null) {
									service.excluir(dados, iClienteDao);
									JOptionPane.showMessageDialog(null,"Cliente Excluido ","Exclusao",JOptionPane.INFORMATION_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null,"Cliente não encontrado ","Consulta",JOptionPane.ERROR_MESSAGE);
								}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnExcluir.setBounds(135, 57, 89, 23);
		contentPane.add(btnExcluir);
/*		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
								UpdateDialog dialog = new UpdateDialog();
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setLocationRelativeTo(null);
								dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnUpdate.setBounds(135, 23, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
								DeleteDialog dialog = new DeleteDialog();
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setLocationRelativeTo(null);
								dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDelete.setBounds(234, 23, 89, 23);
		contentPane.add(btnDelete);*/
		
		/*JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                    	DefaultTableModel tableModel = new DefaultTableModel();
                    	JTable table = new JTable(tableModel);
                    	ContactDAO cDAO=new ContactDAO();
                    	cDAO.loadData(tableModel);
                    	JOptionPane.showMessageDialog(null, new JScrollPane(table));
                        return null;
                    }
                }.execute();
			}
		});
		btnSelect.setBounds(135, 57, 89, 23);
		contentPane.add(btnSelect);*/
	}
}
