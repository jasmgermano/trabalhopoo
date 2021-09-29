package trabalhopoo;

public class promocoes {
	private int idpromocoes;
	private String nome;
	private String descricao;
	private float desconto;
	public promocoes(int idpromocoes, String nome, String descricao, float desconto) {
		this.idpromocoes = idpromocoes;
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
	}
	
	public promocoes(String nome) {
		this.nome = nome;
	}
	
	public promocoes() {
		
	}
	public int getIdpromocoes() {
		return idpromocoes;
	}
	public void setIdpromocoes(int idpromocoes) {
		this.idpromocoes = idpromocoes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	
}
