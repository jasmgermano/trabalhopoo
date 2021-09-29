package trabalhopoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import trabalhopoo.conexaobd;

public class conexaobd {
	/* Utilização da classe Connection do pacote java.sql para criar um objeto que será configurado para conectar no banco de dados*/
	Connection conexao; 
	
	/* Método que configura a conexão e retornar o objeto "conexao" com estado da conexão, ou seja, conexão aberta ou nula/null (sem conexão)*/
	public Connection iniciaConexao(){
		try {
			//Configuração do nome do driver (fabricante)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Configuração do caminho, usuário e senha
			String caminho = "jdbc:mysql://localhost:3306/trabalhopoo?useTimezone=true&serverTimezone=GMT";
			String user = "root";
			String senha = "2013090201";
			
			//Abrindo a conexão com o banco de dados
			conexao = DriverManager.getConnection(caminho, user,senha);
			
			//Se conseguiu conectar com o banco de dados...
			System.out.println("Conexão realizada!"); //exibe mensagem
			
		} catch (Exception e) {
			System.out.println("Não foi possível conectar.");
			//Imprimir os erros que foram capturados
			e.printStackTrace();
		}
		return conexao;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new conexaobd().iniciaConexao(); 
	}
	

}
