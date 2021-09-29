package trabalhopoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;



public class comando {
	
		//Objeto da classe connection que irá receber a conexão feita na classe anterior
		Connection conexao;
		public String Acesso;
		public static int id;
		public static float valor;
		//public static LocalDate novareserva = LocalDate.now();
		
		//Método para realizar o INSERT no banco de dados
		public boolean cadastroquarto (quartos q) {
			//Comando (INSERT) a ser executado no banco de dados
			String sql = "INSERT INTO quarto VALUES (?, ?, ?, ?, ?);";

			//Recuperar a conexao que foi montada na outra classe
			conexao = new conexaobd().iniciaConexao();
			try {
				//Preparar o comando sql para ser executado
				PreparedStatement ps = conexao.prepareStatement(sql);

				//Passar valor de ?
				ps.setInt(1, q.getNumQuarto());
				ps.setString(2, q.getTipoQuarto()); //Na primeira ? irá o valor do codigo
				ps.setFloat(3,q.getValorDiaria());
				ps.setFloat(4,q.getTamanho());
				ps.setString(5,q.getDescricao());			
				if(ps.executeUpdate()!=0){
					//Se o comando afetou 1 linha ou mais, quer dizer que deu certo
					conexao.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; //Se caso aconteceu algum erro, retorna falso
		
		}
		

		public boolean estadoNovareserva(reserva r) {
			String sql = "INSERT INTO reserva VALUES (?, ?, ?, ?, ?, ?, ?);";
			LocalDate novareserva = LocalDate.now();
			Date date = java.sql.Date.valueOf(novareserva);
			conexao = new conexaobd().iniciaConexao();
			try {
				PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	
				ps.setInt(1, 0);
				ps.setString(2, "Nova reserva"); 
				ps.setFloat(3, 0);
				ps.setDate(4, (java.sql.Date) date);
				ps.setDate(5, (java.sql.Date) date);
				ps.setString(6, "0");
				ps.setInt(7, 0);
				int a = ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					int teste = 0;
				    teste = rs.getInt(1);
				    id = teste;
					System.out.println(id);
				}else {
					System.out.println("EITAA");
				}

				if(a!=0){
					conexao.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
		
		public boolean selecionaquarto(reserva r) {
			String sql;
			conexao = new conexaobd().iniciaConexao();
			try {
				sql = "UPDATE reserva JOIN quarto SET reserva.status = ?, reserva.checkin = ?, reserva.checkout = ?, reserva.numquarto = ?, reserva.valor = (quarto.valordiaria * ?) "
						+ "WHERE reserva.idreserva = ? AND reserva.numquarto = quarto.numquarto;";
				PreparedStatement ps = conexao.prepareStatement(sql);
				java.sql.Date chegada = java.sql.Date.valueOf(r.getCheckin());
				java.sql.Date saida = java.sql.Date.valueOf(r.getCheckout());
				float dias = ChronoUnit.DAYS.between(r.getCheckin(), r.getCheckout());
				System.out.println(dias);
				ps.setString(1, "Reservado");
				ps.setDate(2, chegada);
				ps.setDate(3, saida); 
				ps.setInt(4, r.getNumquarto());
				ps.setFloat(5, dias+1);
				ps.setInt(6, id);
				System.out.println(id);
				System.out.println(ps.executeUpdate()+" linhas foram atualizadas");
				if(ps.executeUpdate()!=0){
					conexao.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
		
		public List<hospede> buscaHospede(){
			List<hospede> lista = new ArrayList<hospede>();
			String sql = "SELECT * FROM hospede;";

			//Recuperando a conexao que foi montada na outra classe
			conexao = new conexaobd().iniciaConexao();

			try {
				//Preparar o comando sql para ser executado
				PreparedStatement ps = conexao.prepareStatement(sql);
				// passar valor de ?
				//ps.setString(1, h.getNome());
				//ps.setString(2, h.getSobrenome());

				//Quando usamos o SELECT necessario criar um ResultSet
				ResultSet resultado = ps.executeQuery(); //Executa o comando no banco de dados

				//Enquanto o banco de dados retornar algo
				while(resultado.next()){
					hospede h = new hospede();
					h.setNome(resultado.getString("nome"));
					h.setSobrenome(resultado.getString("sobrenome"));
					h.setEndereco(resultado.getString("endereco"));
					h.setEmail(resultado.getString("email"));
					h.setTelefone(resultado.getString("telefone"));
					h.setId(resultado.getString("rg"));
					lista.add(h);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return lista;
		}
		
		public boolean selecionahospede(reserva r) {
			String sql;
			conexao = new conexaobd().iniciaConexao();
			try {
				sql = "UPDATE reserva SET rg = ? WHERE (idreserva = ?);";
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, r.getRg());
				ps.setInt(2, id);
				if(ps.executeUpdate()!=0){
					conexao.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
		
		public List<promocoes> selecionapromocao() {
			String sql;
			conexao = new conexaobd().iniciaConexao();
			List<promocoes> lista = new ArrayList<promocoes>();
			try {
				sql = "SELECT * FROM promocoes;";
				PreparedStatement ps = conexao.prepareStatement(sql);
					ResultSet resultado = ps.executeQuery();

					while(resultado.next()){
						promocoes p = new promocoes();
						p.setIdpromocoes(resultado.getInt("idpromocoes"));
						p.setDesconto(resultado.getFloat("desconto"));
						p.setDescricao(resultado.getString("descricao"));
						p.setNome(resultado.getString("nome"));

						lista.add(p);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lista; 
		}
		
		public boolean calculavalor(promocoes p) {
			String sql;
			conexao = new conexaobd().iniciaConexao();
			try {
				sql = "UPDATE reserva JOIN promocoes ON promocoes.nome = ? SET reserva.valor = (reserva.valor * promocoes.desconto) WHERE (reserva.idreserva = ?);";
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, p.getNome());
				ps.setInt(2, id);
				if(ps.executeUpdate()!=0){
					conexao.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
		
		public boolean confirmareserva() {
			String sql;
			conexao = new conexaobd().iniciaConexao();
			try {
				sql = "UPDATE reserva SET status = ? WHERE (idreserva = ?);";
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, "Confirmada");
				ps.setInt(2, id);
				if(ps.executeUpdate()!=0){
					conexao.close();
					JOptionPane.showMessageDialog(null, "Código da reserva: "+id);
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
		
		public boolean fazpagamento (pagamentoCartao p) {
			String sql = "INSERT INTO pagamento VALUES (?, ?, ?, ?, ?, ?);";

			conexao = new conexaobd().iniciaConexao();
			try {
				PreparedStatement ps = conexao.prepareStatement(sql);

				ps.setInt(1,0);
				ps.setString(2, p.getNomecartao()); 
				ps.setString(3,p.getNumerocartao());
				ps.setString(4,p.getOperadora());
				ps.setString(5,p.getExpiracao());
				ps.setInt(6,p.getCodseguranca());
				if(ps.executeUpdate()!=0){
					conexao.close();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		
		}
		public List<reserva> buscaquarto(){
			List<reserva> lista = new ArrayList<reserva>();
			String sql = "SELECT * FROM reserva";

			conexao = new conexaobd().iniciaConexao();

			try {
				PreparedStatement ps = conexao.prepareStatement(sql);

				ResultSet resultado = ps.executeQuery(); 
				while(resultado.next()){
					reserva r = new reserva();
					// mudar aqui
					java.sql.Date teste = (java.sql.Date)resultado.getObject("checkin");
					java.sql.Date teste2 = (java.sql.Date)resultado.getObject("checkout");
					r.setCheckin(teste.toLocalDate());
					r.setCheckout(teste2.toLocalDate());
					r.setRg(resultado.getString("rg"));
					r.setIdReserva(resultado.getInt("idreserva"));
					r.setNumquarto(resultado.getInt("numquarto"));
					r.setStatus(resultado.getString("status"));
					r.setValor(resultado.getFloat("valor"));
					lista.add(r);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return lista;
		}
		
		public List<quartos> buscaquarto2(){
			List<quartos> lista = new ArrayList<quartos>();
			String sql = "SELECT * FROM quarto";

			conexao = new conexaobd().iniciaConexao();

			try {
				PreparedStatement ps = conexao.prepareStatement(sql);

				ResultSet resultado = ps.executeQuery(); 
				while(resultado.next()){
					quartos q = new quartos();
					q.setDescricao(resultado.getString("descricao"));
					q.setNumQuarto(resultado.getInt("numquarto"));
					q.setTamanho(resultado.getFloat("tamanho"));
					q.setTipoQuarto(resultado.getString("tipo"));
					q.setValorDiaria(resultado.getFloat("valordiaria"));
					lista.add(q);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return lista;
		}
			
		}



		


