package trabalhopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class selecionaPromocao extends JFrame {

	private JPanel contentPane;
	JComboBox promocoes;

	/**
	 * Create the frame.
	 */
	public selecionaPromocao() {
		inicializaComponentes();
	}

	private void inicializaComponentes() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 175);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		promocoes = new JComboBox();
		promocoes.setBounds(24, 46, 300, 38);
		contentPane.add(promocoes);
		
		JLabel lblNewLabel = new JLabel("Selecionar promoção: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(81, 11, 198, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(124, 95, 89, 23);
		contentPane.add(btnContinuar);
		
		comando c = new comando();
		List<promocoes> lista = c.selecionapromocao();
		List<String> lista1 = new ArrayList<String>();
		for(promocoes p : lista) {
			lista1.add(p.getNome());
			}
		DefaultComboBoxModel comboBox = new DefaultComboBoxModel(lista1.toArray());
		promocoes.setModel(comboBox);
		
		btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				promocoes p = new promocoes((String)promocoes.getSelectedItem());
				comando c = new comando();
				
				if (c.calculavalor(p) == true) {
					buscahospede b = new buscahospede();
					b.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Houve um erro!");
				}
				
			}
		});

		
	}
	
}
