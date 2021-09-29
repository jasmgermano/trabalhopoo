package trabalhopoo;

public class hospede {
	private String rg;
	private String nome;
	private String sobrenome;
	private String endereco;
	private String telefone;
	private String email;
	public hospede(String id, String nome, String sobrenome, String endereco, String telefone, String email) {
		this.rg = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public hospede () {
		
	}
	public String getId() {
		return rg;
	}
	public void setId(String id) {
		this.rg = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
