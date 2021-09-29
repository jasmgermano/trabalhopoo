package trabalhopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class cadastraQuarto extends JFrame {

	private JPanel contentPane;
	List<quartos> cadastros1;
	private JTextField valorDiaria;
	private JTextField tamanho;
	private JTextField numQuarto;
	private JComboBox tipoQuarto;
	private JTextArea descricao;
	List<quartos> cadastros;

	public cadastraQuarto(String nome, List<quartos> cadastro1) {
		setTitle("Cadastrar quartos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setBounds(100, 100, 351, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cadastros1 = new ArrayList<>();
		
		JLabel lbTitulo = new JLabel("CADASTRAR QUARTOS");
		lbTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lbTitulo.setBounds(55, 11, 231, 30);
		contentPane.add(lbTitulo);
		
		JLabel lbtipo = new JLabel("Tipo do quarto");
		lbtipo.setFont(new Font("Arial", Font.PLAIN, 14));
		lbtipo.setBounds(10, 95, 93, 14);
		contentPane.add(lbtipo);
		
		tipoQuarto = new JComboBox();
		tipoQuarto.setModel(new DefaultComboBoxModel(new String[] {"", "Quarto 1 cama solteiro", "Quarto 2 camas solteiro", "Quarto de casal", "Suíte executiva"}));
		tipoQuarto.setToolTipText("");
		tipoQuarto.setFont(new Font("Arial", Font.PLAIN, 13));
		tipoQuarto.setBounds(10, 114, 315, 30);
		contentPane.add(tipoQuarto);
		
		JLabel lbValor = new JLabel("Valor da diária");
		lbValor.setFont(new Font("Arial", Font.PLAIN, 14));
		lbValor.setBounds(10, 155, 93, 14);
		contentPane.add(lbValor);
		
		valorDiaria = new JTextField();
		valorDiaria.setBounds(10, 174, 315, 30);
		contentPane.add(valorDiaria);
		valorDiaria.setColumns(10);
		
		JLabel lbTamanho = new JLabel("Dimensão (em m²)");
		lbTamanho.setFont(new Font("Arial", Font.PLAIN, 14));
		lbTamanho.setBounds(10, 215, 134, 14);
		contentPane.add(lbTamanho);
		
		tamanho = new JTextField();
		tamanho.setColumns(10);
		tamanho.setBounds(10, 234, 315, 30);
		contentPane.add(tamanho);
		
		numQuarto = new JTextField();
		numQuarto.setColumns(10);
		numQuarto.setBounds(10, 59, 315, 30);
		contentPane.add(numQuarto);
		
		JLabel lbNumero = new JLabel("Número do quarto");
		lbNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		lbNumero.setBounds(10, 40, 134, 14);
		contentPane.add(lbNumero);
		
		JLabel lbDescricao = new JLabel("Descrição");
		lbDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDescricao.setBounds(10, 275, 93, 14);
		contentPane.add(lbDescricao);
		
		descricao = new JTextArea();
		descricao.setBounds(10, 300, 315, 68);
		contentPane.add(descricao);
		
		JButton btnCadastraQuarto = new JButton("Cadastrar");
		btnCadastraQuarto.setBounds(116, 379, 100, 30);
		contentPane.add(btnCadastraQuarto);
		
		setVisible(true);
		
		btnCadastraQuarto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quartos q = new quartos((String)tipoQuarto.getSelectedItem(), Float.parseFloat(valorDiaria.getText()), Integer.parseInt(numQuarto.getText()), Float.parseFloat(tamanho.getText()), descricao.getText());
				comando c = new comando();
				
				if (c.cadastroquarto(q) == true) {
					JOptionPane.showMessageDialog(null, "O quarto foi cadastrado com sucesso");
					principal p = new principal("Cadastrar quartos", cadastros1, null);
					p.setVisible(true);
				} else {
				}
				
				dispose();
			}
		});
		
	}
}
