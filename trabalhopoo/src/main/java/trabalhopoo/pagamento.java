package trabalhopoo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pagamento extends JFrame {

	private JPanel contentPane;
	JButton btncontinuar;
	JComboBox escolhepagamento;

	public pagamento() {
		inicializarComponentes();
	}
	

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 196);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o tipo de pagamento: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(34, 33, 242, 22);
		contentPane.add(lblNewLabel);
		
		escolhepagamento = new JComboBox();
		escolhepagamento.setModel(new DefaultComboBoxModel(new String[] {"", "Dinheiro", "Cartão"}));
		escolhepagamento.setBounds(27, 66, 249, 35);
		contentPane.add(escolhepagamento);
		
		btncontinuar = new JButton("Continuar");
		btncontinuar.setBounds(104, 112, 89, 23);
		contentPane.add(btncontinuar);
		
		btncontinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(escolhepagamento.getSelectedItem().equals((String)"Dinheiro")){
					reserva r = new reserva();
					comando c = new comando();
					if(c.confirmareserva() == true) {
					JOptionPane.showMessageDialog(null, "Reserva confirmada!");
					principal p = new principal("Reserva confirmada", null, null );
					p.setVisible(true);
					dispose();
					}
				} else {
					if(escolhepagamento.getSelectedItem().equals((String)"Cartão")){
						pagamentocomcartao p = new pagamentocomcartao();
						p.setVisible(true);
					}
				}
			}
		});
		
		
		
		
	}

}
