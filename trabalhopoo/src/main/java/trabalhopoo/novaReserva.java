package trabalhopoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class novaReserva extends JFrame {

	private JPanel contentPane;
	List<reserva> cadastros2;
	private JTextField chegada;
	private JTextField saida;
	private JButton btnReserva;
	private JComboBox mostrarquartos;
	private JTextArea mostrar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox escolhetipo;
	private JLabel lblNewLabel_4;


	public novaReserva(String titulo, List<reserva> cadastro2) {
		setTitle("Quartos disponiveis");
		this.cadastros2=cadastro2;
		inicializarComponentes();
	}


	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Verificar quartos disponíveis");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(21, 11, 262, 14);
		contentPane.add(lblNewLabel);
		
		chegada = new JTextField();
		chegada.setBounds(21, 58, 133, 20);
		contentPane.add(chegada);
		chegada.setColumns(10);
		cadastros2 = new ArrayList<>();
		
		saida = new JTextField();
		saida.setColumns(10);
		saida.setBounds(180, 58, 133, 20);
		contentPane.add(saida);
		
		JButton btnVerifica = new JButton("Verificar");
		btnVerifica.setBounds(180, 147, 89, 23);
		contentPane.add(btnVerifica);
		
		btnReserva = new JButton("Continuar reserva");
		btnReserva.setBounds(147, 387, 155, 23);
		contentPane.add(btnReserva);
		
		mostrarquartos = new JComboBox();
		mostrarquartos.setModel(new DefaultComboBoxModel(new String[] {" "}));
		mostrarquartos.setFont(new Font("Arial", Font.PLAIN, 12));
		mostrarquartos.setBounds(21, 198, 391, 35);
		contentPane.add(mostrarquartos);
		
		mostrar = new JTextArea();
		mostrar.setEditable(false);
		mostrar.setBounds(21, 244, 391, 132);
		contentPane.add(mostrar);
		
		lblNewLabel_1 = new JLabel("Número dos quartos disponíveis");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(21, 182, 203, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Data de chegada");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(21, 43, 104, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Data de saída");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(179, 43, 104, 14);
		contentPane.add(lblNewLabel_3);
		
		escolhetipo = new JComboBox();
		escolhetipo.setModel(new DefaultComboBoxModel(new String[] {"Quarto 1 cama solteiro", "Quarto 2 camas solteiro", "Quarto de casal", "Suíte executiva", "Todos"}));
		escolhetipo.setFont(new Font("Arial", Font.PLAIN, 12));
		escolhetipo.setBounds(21, 101, 391, 35);
		contentPane.add(escolhetipo);
		
		lblNewLabel_4 = new JLabel("Tipo de quarto");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(21, 86, 104, 14);
		contentPane.add(lblNewLabel_4);
			
		
		btnVerifica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comando c = new comando();
				mostrar.setText(" ");
				List<LocalDate> lista1 = new ArrayList<LocalDate>();
				List<Integer> quartosdisponiveis = new ArrayList<Integer>();
				// coverter texto pra data
				LocalDate teste = LocalDate.parse(chegada.getText());
				LocalDate teste2 = LocalDate.parse(saida.getText());
				// converter data pra string
				
				while (teste.isBefore(teste2) || teste.equals(teste2)) {
					lista1.add(teste);
					teste = teste.plusDays(1);	
				}
				
				List<reserva> lista = c.buscaquarto();
				
				for (reserva qd : lista) {
					int cont = 1;
					LocalDate chegada = qd.getCheckin();
					//data1 = dateFormat.format(qd.getCheckin()); //checkins ja feitos
					
					while(chegada.isBefore(qd.getCheckout()) || chegada.equals(qd.getCheckout())) {
						if (lista1.contains(chegada)) {
							quartosdisponiveis.add(qd.getNumquarto());
							cont = 0;
							break;
						} else {
							chegada = chegada.plusDays(1);
						}
						
				}
					if(cont != 0) {
						
					}
					
					//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");      
					//String data1;
					//data1 = dateFormat.format(qd.getCheckin()); //checkins ja feitos
				}
				
				
					
				List<quartos> listaquartos = c.buscaquarto2();
				List<Integer> listaNum = new ArrayList<Integer>();
				listaNum.add(null);
				for (quartos qd : listaquartos) {
					if(!quartosdisponiveis.contains(qd.getNumQuarto()) && qd.getNumQuarto()!=0 && escolhetipo.getSelectedItem().equals("Todos")) {
						/* mostrar.append("Número do quarto: "+qd.getNumQuarto()+"\n"+
					"Tipo quarto: "+qd.getTipoQuarto()+"\n"+"Tamanho quarto: "+qd.getTamanho()+"\n"+
								"Valor diária: "+qd.getValorDiaria()+"\n\n"); */
						listaNum.add(qd.getNumQuarto());
					}	
					if(!quartosdisponiveis.contains(qd.getNumQuarto()) && qd.getNumQuarto()!=0 && escolhetipo.getSelectedItem().equals(qd.getTipoQuarto())) {
						/* mostrar.append("Número do quarto: "+qd.getNumQuarto()+"\n"+
					"Tipo quarto: "+qd.getTipoQuarto()+"\n"+"Tamanho quarto: "+qd.getTamanho()+"\n"+
								"Valor diária: "+qd.getValorDiaria()+"\n\n"); */
						listaNum.add(qd.getNumQuarto());
					}	
				}
				
				if(listaNum.isEmpty()) {
					mostrar.append("Nenhum quarto disponivel");
				}
				DefaultComboBoxModel combobox = new DefaultComboBoxModel(listaNum.toArray());
				mostrarquartos.setModel(combobox);
					
			}
		});
		
		mostrarquartos.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				comando c = new comando();
				List<quartos> listaquartos = c.buscaquarto2();
				mostrar.setText(" ");
				if (e.getStateChange() == ItemEvent.SELECTED) {
				int comparar = (Integer) mostrarquartos.getSelectedItem();
				for (quartos qd : listaquartos) {
					if(comparar == qd.getNumQuarto()) {
						mostrar.append("Número do quarto: "+qd.getNumQuarto()+"\n"+
								"Tipo quarto: "+qd.getTipoQuarto()+"\n"+"Tamanho quarto: "+qd.getTamanho()+"\n"+
											"Valor diária: "+qd.getValorDiaria()+"\nDecrição: "+qd.getDescricao()+"\n\n");
					}
				}
				}
			}
		});
		
		btnReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reserva r = new reserva(LocalDate.parse(chegada.getText()),LocalDate.parse(saida.getText()), (Integer) mostrarquartos.getSelectedItem());
				comando c = new comando();
				mostrar.setText(" ");
				if(c.selecionaquarto(r) == true) {
					JOptionPane.showMessageDialog(null, "Quarto selecionado com sucesso");
					selecionaPromocao h = new selecionaPromocao();
					h.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "epa!");
				}
			}
		});
	}
}
