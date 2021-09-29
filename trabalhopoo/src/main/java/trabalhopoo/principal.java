package trabalhopoo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class principal extends JFrame {

	private JPanel contentPane;
	List<quartos> cadastro1;
	List<reserva> cadastro2;
	private JTextField jtfNome;

	public principal(String nome, List<quartos> cadastro1, List<reserva> cadastro2) {
		this.cadastro1=cadastro1;
		this.cadastro2=cadastro2;
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 262);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SEJA BEM-VINDO(A)! ESCOLHA O QUE QUER FAZER:");
		lblNewLabel_1.setBounds(59, 87, 263, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JButton novareserva = new JButton("Nova reserva");
		novareserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		novareserva.setBounds(92, 161, 157, 38);
		novareserva.setBackground(new Color(245, 222, 179));
		contentPane.add(novareserva);
		
		JButton cadastrarquarto = new JButton("Cadastrar quarto");
		cadastrarquarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cadastrarquarto.setBackground(new Color(245, 222, 179));
		cadastrarquarto.setBounds(92, 112, 157, 38);
		contentPane.add(cadastrarquarto);
		
		JLabel lblNewLabel = new JLabel(" Sparkling Water");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(82, 22, 196, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("albergue");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(113, 51, 63, 18);
		contentPane.add(lblNewLabel_2);
		comando p = new comando();
		
		cadastrarquarto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cadastraQuarto cq = new cadastraQuarto ("Cadastrar", principal.this.cadastro1);
				cq.setVisible(true);
				dispose();
			}
		});
		
		novareserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				comando c = new comando();
				reserva r = new reserva();
				
				if (c.estadoNovareserva(r) == true) {
					JOptionPane.showMessageDialog(null, "Oba! Uma nova reserva foi criada");
					novaReserva nr = new novaReserva("Nova reserva", principal.this.cadastro2);
					nr.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao criar a reserva");
				}
				
				
				
			}
		});
	}
	public principal() {
		// TODO Auto-generated constructor stub
	}
}

