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

import br.com.inforium.DAO.LocadoraDAO;
import br.com.inforium.entidade.Locadoras;
import br.com.inforium.entidade.Veiculos;
import br.com.inforium.model.TableModel;
import br.com.inforium.util.DataUtil;

public class TelaLocadora {
	
	private JFrame frame;
	private JTextField txtIDLocadora;
	private JTextField txtModelo;
	private String[] colunas = {"Locadora", "Ano", "Cor", "Modelo","Placa"};
	private Object[][] dados = { { "", "", "", "" , ""} };
	private JTable tabela = new JTable(dados, colunas);
	DefaultTableModel model;
	private List<Veiculos> listaCarros;
	LocadoraDAO dao;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLocadora window = new TelaLocadora();
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
	public TelaLocadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		dao = new LocadoraDAO();
		frame.setBounds(100, 100, 591, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			montaTabela();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("ID Locadora:");
		lblNewLabel.setBounds(10, 23, 94, 16);
		frame.getContentPane().add(lblNewLabel);

		txtIDLocadora = new JTextField();
		txtIDLocadora.setBounds(79, 18, 117, 26);
		frame.getContentPane().add(txtIDLocadora);
		txtIDLocadora.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setBounds(10, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		txtModelo = new JTextField();
		txtModelo.setBounds(64, 50, 132, 26);
		frame.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

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
				Veiculos a = new Veiculos();
				LocadoraDAO dao = new LocadoraDAO();
				a.setDataEntrega(dateEntrega.getDate());
				a.setDataRetirada(dateRetirada.getDate());
				a.setNome(txtModelo.getText());
				
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
				
					txtIDLocadora.setText("");
					dateRetirada.setDate(null);
					txtModelo.setText("");
					dateEntrega.setDate(null);;								
				
			}
		});
		btnLimpar.setBounds(446, 228, 117, 43);
		frame.getContentPane().add(btnLimpar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocadoraDAO dao = new LocadoraDAO();
				Locadoras a = dao.recuperar(Integer.parseInt(txtIDLocadora.getText()));
				
				txtModelo.setText(a.getNome());	
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
				LocadoraDAO dao = new LocadoraDAO();
				a.setId(Integer.parseInt(txtIDLocadora.getText()));
				dao.excluir(a);
				try {
					montaTabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		btnExcluir.setBounds(446, 175, 117, 41);
		frame.getContentPane().add(btnExcluir);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locadoras a = new Locadoras();
				LocadoraDAO dao = new LocadoraDAO();
				a.setId(Integer.parseInt(txtIDLocadora.getText()));
				a.setDataEntrega(dateEntrega.getDate());
				a.setDataRetirada(dateRetirada.getDate());
				a.setNome(txtModelo.getText());
			
				dao.atualizar(a);
			}
		});
		btnNewButton.setBounds(446, 122, 117, 41);
		frame.getContentPane().add(btnNewButton);
		

	}
	
	@SuppressWarnings("deprecation")
	public void montaTabela() throws SQLException {
		listaCarros = dao.recuperarTodos();

		String[] linha = new String[4];
		model = new DefaultTableModel(dados, colunas);
		for (Locadoras l : listaCarros) {
			
			
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


