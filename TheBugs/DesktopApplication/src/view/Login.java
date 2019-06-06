package view;

//extends CadastroProduto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.geom.AreaOp.AddOp;

import controller.LoginController;
import controller.ProdutoController;
import entities.Produto;

import javax.swing.JTable;
import javax.swing.JPanel;

public class Login {

	private JFrame login;
	private JFrame cadastro;
	private JFrame intermediario;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	
	private JTextField txtDescricao;
	private JTextField txtMarca;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeImagem;
	private JTextField txtUnidade;
	private JButton Voltar;
	private String userLogged;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.login.setVisible(true);
					//window.TelaCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//============================================================
		
					//TELA lOGIN
		
		//============================================================
		
		login = new JFrame();
		login.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		login.setBackground(Color.LIGHT_GRAY);
		login.setTitle("LOGIN");
		login.setBounds(100, 100, 298, 210);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBackground(Color.GRAY);
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsuario.setBounds(42, 74, 57, 23);
		login.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(110, 75, 86, 20);
		login.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSenha.setBackground(Color.GRAY);
		lblSenha.setBounds(42, 109, 46, 14);
		login.getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(110, 106, 86, 20);
		login.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//acesso.UserCheck(txtUsuario.getText(),txtSenha.getText());
				if (LoginController.userCheck(txtUsuario.getText(), txtSenha.getText())) {
					userLogged = txtUsuario.getText();
					login.setVisible(false);
					intermediario.setVisible(true);			
				} else {
					JOptionPane.showMessageDialog(null,"Usuario ou senha incorreta.","Login",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(110, 137, 86, 23);
		login.getContentPane().add(btnLogin);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBackground(Color.GRAY);
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(64, 11, 159, 43);
		login.getContentPane().add(lblLogin);
		
		//============================================================
		
		//TELA CADASTRO PRODUTO

		//============================================================

		
		cadastro = new JFrame();
		cadastro.setTitle("CADASTRO");
		cadastro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cadastro.setBackground(Color.LIGHT_GRAY);
		cadastro.setBounds(100, 100, 449, 474);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.getContentPane().setLayout(null);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(156, 38, 119, 28);
		cadastro.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton Cadastrar = new JButton("Salvar");
		Cadastrar.setBackground(Color.LIGHT_GRAY);
		Cadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ProdutoController.cadastrarProduto(txtCodigoProduto.getText(), txtDescricao.getText(), txtMarca.getText(), 
													   txtUnidade.getText(), txtNomeImagem.getText());
					ClearFields();
					ClearTable();
					PreencherProdutos(ProdutoController.listarProdutos());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Ocorreu um erro ao cadastrar o produto","Cadastro Produto",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		Cadastrar.setBounds(287, 89, 120, 23);
		cadastro.getContentPane().add(Cadastrar);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(287, 38, 120, 28);
		cadastro.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel Descricao = new JLabel("Descricao");
		Descricao.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Descricao.setBounds(156, 20, 89, 14);
		cadastro.getContentPane().add(Descricao);
		
		JLabel Marca = new JLabel("Marca");
		Marca.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Marca.setBounds(287, 20, 46, 14);
		cadastro.getContentPane().add(Marca);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBounds(23, 38, 119, 28);
		cadastro.getContentPane().add(txtCodigoProduto);
		
		JLabel CodigoProduto = new JLabel("Codigo Produto");
		CodigoProduto.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		CodigoProduto.setBounds(23, 20, 138, 14);
		cadastro.getContentPane().add(CodigoProduto);
		
		txtNomeImagem = new JTextField();
		txtNomeImagem.setColumns(10);
		txtNomeImagem.setBounds(156, 85, 119, 28);
		cadastro.getContentPane().add(txtNomeImagem);
		
		JLabel NomeImagem = new JLabel("Nome Imagem");
		NomeImagem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		NomeImagem.setBounds(156, 69, 90, 14);
		cadastro.getContentPane().add(NomeImagem);
		
		txtUnidade = new JTextField();
		txtUnidade.setColumns(10);
		txtUnidade.setBounds(23, 85, 119, 28);
		cadastro.getContentPane().add(txtUnidade);
		
		JLabel Unidade = new JLabel("Unidade");
		Unidade.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Unidade.setBounds(23, 69, 65, 14);
		cadastro.getContentPane().add(Unidade);
		
		JButton Voltar = new JButton("Voltar");
		Voltar.setBackground(Color.LIGHT_GRAY);
		Voltar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Voltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				intermediario.setVisible(true);
				cadastro.setVisible(false);	
			}
		});
		Voltar.setBounds(302, 139, 105, 23);
		cadastro.getContentPane().add(Voltar);
	
		JButton button = new JButton("Editar");
		button.setBounds(23, 137, 97, 25);
		cadastro.getContentPane().add(button);
		
		JButton button_1 = new JButton("Excluir");
		button_1.setBounds(156, 137, 97, 25);
		cadastro.getContentPane().add(button_1);

		JPanel panel = new JPanel();
		panel.setBounds(12, 175, 425, 250);
		cadastro.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo Produto", "Descricao", "Marca", "Unidade", "Nome Imagem"
				}
			));
		
		
		table.setPreferredScrollableViewportSize(new Dimension(239,400));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(104);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(113);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(0, 0, panel.getWidth()-30, panel.getHeight()-30);
		table.setBounds(0, 13, panel.getWidth() - 30, panel.getHeight()-30);
		js.setVisible(true);
		panel.add(js);
		//============================================================
		
		//TELA INTERMEDIARIA

		//============================================================
		
		
		intermediario = new JFrame();
		intermediario.setTitle("INTERMEDIARIA");
		intermediario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		intermediario.setBounds(100, 100, 228, 258);
		intermediario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intermediario.getContentPane().setLayout(null);
		
		JButton Relatorio = new JButton("Relatorio");
		Relatorio.setBackground(Color.LIGHT_GRAY);
		Relatorio.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Relatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "relatorio impresso com sucesso", "Relatório", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Relatorio.setBounds(64, 37, 89, 23);
		intermediario.getContentPane().add(Relatorio);
		
		JButton Cadastro = new JButton("Cadastro");
		Cadastro.setBackground(Color.LIGHT_GRAY);
		Cadastro.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Cadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				intermediario.setVisible(false);
				ClearFields();
				ClearTable();
				PreencherProdutos(ProdutoController.listarProdutos());
				cadastro.setVisible(true);	
			}
		});
		Cadastro.setBounds(64, 97, 89, 23);
		intermediario.getContentPane().add(Cadastro);
		
		JButton Logout = new JButton("Logout");
		Logout.setBackground(Color.LIGHT_GRAY);
		Logout.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				intermediario.setVisible(false);
				login.setVisible(true);
				userLogged = "";
			}
		});
		Logout.setBounds(64, 157, 89, 23);
		intermediario.getContentPane().add(Logout);
	}
	
	public void PreencherProdutos(List<Produto> produtosCadastrados) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		for (Produto produto : produtosCadastrados) {
			modelo.addRow(new Object[] {
				produto.getCodigoProduto(),
				produto.getDescricao(),
				produto.getMarca(),
				produto.getUnidade(),
				produto.getNomeImagem()
			});
		}
	}
	
	public void ClearTable() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		if (modelo.getRowCount() > 0) {
			for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
				modelo.removeRow(i);
			}
		}
	}
	
	public void ClearFields() {
		txtCodigoProduto.setText("");
		txtDescricao.setText("");
		txtMarca.setText("");
		txtUnidade.setText("");
		txtNomeImagem.setText("");
	}
}
