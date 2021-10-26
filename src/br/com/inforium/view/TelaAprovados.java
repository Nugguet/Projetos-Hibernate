package br.com.inforium.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.inforium.DAO.AprovadosDAO;
import br.com.inforium.entidade.Aprovados;
import br.com.inforium.util.DataUtil;

public class TelaAprovados {
	
	private JFrame frame;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtCurso;
	private JTextField txtNota;
	/*/private String[] colunas = { "Id", "Nome", "Curso" ,"Nota"};
	private Object[][] dados = { { "", "", "",""} };
	private JTable tabela = new JTable(dados, colunas);
	DefaultTableModel model;
	private List<Aprovados> listaAprovados;
	private Connection connection;/*/
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAprovados window = new TelaAprovados();
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
	public TelaAprovados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 23, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(66, 18, 130, 26);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(66, 50, 152, 26);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Curso:");
		lblNewLabel_2.setBounds(228, 23, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);

		txtCurso = new JTextField();
		txtCurso.setBounds(284, 18, 152, 26);
		frame.getContentPane().add(txtCurso);
		txtCurso.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nota:");
		lblNewLabel_1_2.setBounds(228, 55, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtNota = new JTextField();
		txtNota.setColumns(10);
		txtNota.setBounds(284, 50, 152, 26);
		frame.getContentPane().add(txtNota);
		
	/*/	connection = ConexaoMySQL.ReiniciarConexao();
		if (connection != null) {
			try {
				montaTabela();

			} catch (SQLException e1) {
				System.out.println("Erro Conexão Invalida!");
			}
		}
		
		/*/
		
		JButton btnConfrimar = new JButton("Cadastrar");
		btnConfrimar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aprovados a = new Aprovados();
				AprovadosDAO dao = new AprovadosDAO();
				a.setCurso(txtCurso.getText());
				a.setDataResultado(new Date());
				a.setNome(txtNome.getText());
				a.setNota(Integer.parseInt(txtNota.getText()));
				dao.incluir(a);
			}
		});
		btnConfrimar.setBounds(465, 73, 117, 41);
		frame.getContentPane().add(btnConfrimar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
					txtID.setText("");
					txtCurso.setText("");
					txtNome.setText("");
					txtNota.setText("");								
				
			}
		});
		btnLimpar.setBounds(465, 228, 117, 43);
		frame.getContentPane().add(btnLimpar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aprovados a = new Aprovados();
				AprovadosDAO dao = new AprovadosDAO();
				List<Aprovados> lista = new ArrayList<Aprovados>();
				lista = dao.recuperarTodos();
				
				

				for (Aprovados aprovados : lista) {
					
					
					
					
				//	txtNota.setText(Integer.parseInt(aprovados.getNota()));
					
					/*/
					
					txtNota.setText(Integer.toString(a.getNota()));
					
					
					
					
					a.setNome(txtNota.getText());
				
					a.setId(Integer.parseInt(txtNota.getText()));
					aprovados.setNota(Integer.parseInt(txtNota.getText()));
					
					
					/*/
					System.out.println(aprovados.getNome());
					System.out.println(aprovados.getCurso());
					System.out.println(aprovados.getNota());
					System.out.println(DataUtil.parseDate(aprovados.getDataResultado()));
					System.out.println("*******");

				}

			}
		});
		btnPesquisar.setBounds(465, 18, 117, 43);
		frame.getContentPane().add(btnPesquisar);
		
		

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aprovados a = new Aprovados();
				AprovadosDAO dao = new AprovadosDAO();
				a.setId(Integer.parseInt(txtID.getText()));
				dao.excluir(a);
			}
		});

		btnExcluir.setBounds(465, 175, 117, 41);
		frame.getContentPane().add(btnExcluir);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aprovados a = new Aprovados();
				AprovadosDAO dao = new AprovadosDAO();
				a.setId(Integer.parseInt(txtID.getText()));
				a.setCurso(txtCurso.getText());
				a.setDataResultado(new Date());
				a.setNome(txtNome.getText());
				a.setNota(Integer.parseInt(txtNota.getText()));
				dao.atualizar(a);
			}
		});
		btnNewButton.setBounds(465, 122, 117, 41);
		frame.getContentPane().add(btnNewButton);
		
	
		
		

	}
	
	/*/
	
	public void montaTabela() throws SQLException {
		listaAprovados = ConexaoMySQL.pesquisar(connection);

		String[] linha = new String[4];
		model = new DefaultTableModel(dados, colunas);
		for (Aprovados tb_aprovados : listaAprovados) {
			linha[0] = tb_aprovados.getId() + "";
			linha[1] = tb_aprovados.getNome();
			linha[2] = tb_aprovados.getCurso();
			linha[3] = tb_aprovados.getNota() + "";			
			model.addRow(linha);
		}
		model.removeRow(0);
		tabela.setModel(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		scrollPane.setBounds(16, 152, 440, 170);
		scrollPane.show(true);
		frame.getContentPane().add(scrollPane);

	}
	
	/*/
		
	}


