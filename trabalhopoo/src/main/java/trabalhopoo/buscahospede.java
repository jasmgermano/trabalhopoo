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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class buscahospede extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField sobrenome;
	private JButton btnhospede;
	JComboBox rgHospedes;

	/**
	 * Create the frame.
	 */
	public buscahospede() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 265);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar hóspede");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 21, 162, 18);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(29, 67, 142, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(29, 50, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		sobrenome = new JTextField();
		sobrenome.setColumns(10);
		sobrenome.setBounds(181, 67, 142, 20);
		contentPane.add(sobrenome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sobrenome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(181, 50, 72, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnMostrar = new JButton("Buscar");
		btnMostrar.setBounds(335, 66, 89, 23);
		contentPane.add(btnMostrar);
		
		btnhospede = new JButton("Continuar reserva");
		btnhospede.setBounds(127, 178, 196, 23);
		contentPane.add(btnhospede);
		
		JLabel lblNewLabel_2 = new JLabel("RG dos hóspedes encontrados: ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(29, 98, 307, 20);
		contentPane.add(lblNewLabel_2);
		
		rgHospedes = new JComboBox();
		rgHospedes.setBounds(29, 122, 207, 23);
		contentPane.add(rgHospedes);
		
		btnMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comando c = new comando();
				List<hospede> lista = c.buscaHospede();
				List<String> lista1 = new ArrayList<String>();

				for(hospede hospede : lista) {
					if(hospede.getNome().equals(nome.getText()) && hospede.getSobrenome().equals(sobrenome.getText())) {
					// mostra.append("Id hóspede: "+hospede.getId()+"\nNome: "+hospede.getNome()+" "+hospede.getSobrenome()+"\n");
						lista1.add(hospede.getId());
					}
				}
				DefaultComboBoxModel comboBox = new DefaultComboBoxModel(lista1.toArray());
				rgHospedes.setModel(comboBox);
			}
		});
		
		btnhospede.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reserva r = new reserva((String)rgHospedes.getSelectedItem());
				comando c = new comando();
				
				if(c.selecionahospede(r) == true) {
					JOptionPane.showMessageDialog(null, "Hóspede selecionado com sucesso");
					pagamento p = new pagamento();
					p.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "epa!");
				}
			}
		});
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buscahospede p = new buscahospede();
		p.setVisible(true); // torna frame visivel

	}
}
