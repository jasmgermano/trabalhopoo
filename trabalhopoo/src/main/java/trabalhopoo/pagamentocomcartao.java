package trabalhopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class pagamentocomcartao extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField numero;
	private JTextField operadora;
	private JTextField expiracao;
	private JTextField codseg;


	public pagamentocomcartao() {
		inicializarComponentes();
	}


	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Preencha com os dados do cartão:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(34, 31, 292, 22);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(34, 84, 292, 32);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 69, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Número");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(34, 127, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(34, 142, 292, 32);
		contentPane.add(numero);
		
		JLabel lblNewLabel_1_2 = new JLabel("Operadora");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(34, 185, 95, 14);
		contentPane.add(lblNewLabel_1_2);
		
		operadora = new JTextField();
		operadora.setColumns(10);
		operadora.setBounds(34, 200, 292, 32);
		contentPane.add(operadora);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data expiração");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(34, 243, 95, 14);
		contentPane.add(lblNewLabel_1_3);
		
		expiracao = new JTextField();
		expiracao.setColumns(10);
		expiracao.setBounds(34, 258, 292, 32);
		contentPane.add(expiracao);
		
		JLabel lblNewLabel_1_4 = new JLabel("Código de segurança");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(34, 305, 119, 14);
		contentPane.add(lblNewLabel_1_4);
		
		codseg = new JTextField();
		codseg.setColumns(10);
		codseg.setBounds(34, 320, 292, 32);
		contentPane.add(codseg);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(129, 363, 89, 23);
		contentPane.add(btnContinuar);
		
		btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pagamentoCartao pg = new pagamentoCartao(nome.getText(), numero.getText(), operadora.getText(), expiracao.getText(), Integer.parseInt(codseg.getText()));
				comando c = new comando();
				
				if (c.fazpagamento(pg) == true) {
					JOptionPane.showMessageDialog(null, "Crédito autorizado");
					reserva r = new reserva();
					if(c.confirmareserva() == true) {
					JOptionPane.showMessageDialog(null, "Reserva confirmada!");
					principal p = new principal("",null,null);
					p.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Houve um erro!");
				}
				
				dispose();
			}
		});
	}

}
