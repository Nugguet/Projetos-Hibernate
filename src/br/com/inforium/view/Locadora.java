package br.com.inforium.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import br.com.inforium.DAO.LocadorasDAO;
import br.com.inforium.entidade.Locadoras;
import br.com.inforium.util.DataUtil;

public class Locadora {
	
	private JFrame frame;
	private JTextField txtID;
	private JTextField txtNome;
	private String[] colunas = {"ID", "Titulo", "Data Entrega", "Data Devolução"};
	private Object[][] dados = { { "", "", "", "" , ""} };
	private JTable tabela = new JTable(dados, colunas);
	DefaultTableModel model;
	private List<Locadoras> listaFilmes;
	LocadorasDAO dao;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locadora window = new Locadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Locadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		dao = new LocadorasDAO();
		frame.setBounds(100, 100, 591, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			montaTabela();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(27, 23, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(66, 18, 130, 26);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(27, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(66, 50, 152, 26);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Retirada:");
		lblNewLabel_2.setBounds(228, 23, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Entrega:");
		lblNewLabel_1_2.setBounds(228, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JDateChooser dateRetirada = new JDateChooser();
		dateRetirada.setBounds(284, 18, 152, 27);
		frame.getContentPane().add(dateRetirada);
		
		JDateChooser dateEntrega = new JDateChooser();
		dateEntrega.setBounds(284, 50, 152, 27);
		frame.getContentPane().add(dateEntrega);
		
		
		JButton btnConfrimar = new JButton("Cadastrar");
		btnConfrimar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locadoras a = new Locadoras();
				LocadorasDAO dao = new LocadorasDAO();
				a.setDataEntrega(dateEntrega.getDate());
				a.setDataRetirada(dateRetirada.getDate());
				a.setNome(txtNome.getText());
				
				dao.incluir(a);
				JOptionPane.showMessageDialog(null, "Registro Incluido com sucesso!!");
				try {
					montaTabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnConfrimar.setBounds(446, 73, 117, 41);
		frame.getContentPane().add(btnConfrimar);
		
		
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
					txtID.setText("");
					dateRetirada.setDate(null);
					txtNome.setText("");
					dateEntrega.setDate(null);;								
				
			}
		});
		btnLimpar.setBounds(446, 228, 117, 43);
		frame.getContentPane().add(btnLimpar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocadorasDAO dao = new LocadorasDAO();
				Locadoras a = dao.recuperar(Integer.parseInt(txtID.getText()));
				
				txtNome.setText(a.getNome());	
				dateRetirada.setDate(a.getDataRetirada());	
				dateEntrega.setDate(a.getDataEntrega());				
							
			
			}
		});
		btnPesquisar.setBounds(446, 18, 117, 43);
		frame.getContentPane().add(btnPesquisar);
		
		

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locadoras a = new Locadoras();
				LocadorasDAO dao = new LocadorasDAO();
				a.setId(Integer.parseInt(txtID.getText()));
				dao.excluir(a);
			}
		});

		btnExcluir.setBounds(446, 175, 117, 41);
		frame.getContentPane().add(btnExcluir);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locadoras a = new Locadoras();
				LocadorasDAO dao = new LocadorasDAO();
				a.setId(Integer.parseInt(txtID.getText()));
				a.setDataEntrega(dateEntrega.getDate());
				a.setDataRetirada(dateRetirada.getDate());
				a.setNome(txtNome.getText());
			
				dao.atualizar(a);
			}
		});
		btnNewButton.setBounds(446, 122, 117, 41);
		frame.getContentPane().add(btnNewButton);
		

	}
	
	@SuppressWarnings("deprecation")
	public void montaTabela() throws SQLException {
		listaFilmes = dao.recuperarTodos();

		String[] linha = new String[4];
		model = new DefaultTableModel(dados, colunas);
		for (Locadoras l : listaFilmes) {
			
			
			linha[0] = l.getId() + "";
			linha[1] = l.getNome() + "";
			linha[2] = DataUtil.parseDate(l.getDataRetirada());
			linha[3] = DataUtil.parseDate(l.getDataEntrega());
			
			model.addRow(linha);
		}
		model.removeRow(0);
		tabela.setModel(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		scrollPane.setBounds(27, 87, 410, 184);
		scrollPane.show(true);
		frame.getContentPane().add(scrollPane);
	
	}}


