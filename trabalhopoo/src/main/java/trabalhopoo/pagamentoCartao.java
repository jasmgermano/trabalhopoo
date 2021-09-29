package trabalhopoo;

public class pagamentoCartao {
	private int idpagamento;
	private String nomecartao;
	private String numerocartao;
	private String operadora;
	private String expiracao;
	private int codseguranca;
	public pagamentoCartao(int idpagamento, String nomecartao, String numerocartao, String operadora, String expiracao,
			int codseguranca) {
		this.idpagamento = idpagamento;
		this.nomecartao = nomecartao;
		this.numerocartao = numerocartao;
		this.operadora = operadora;
		this.expiracao = expiracao;
		this.codseguranca = codseguranca;
	}
	public pagamentoCartao(String nomecartao, String numerocartao, String operadora, String expiracao,
			int codseguranca) {
		this.nomecartao = nomecartao;
		this.numerocartao = numerocartao;
		this.operadora = operadora;
		this.expiracao = expiracao;
		this.codseguranca = codseguranca;
	}
	public pagamentoCartao () {
		
	}
	public int getIdpagamento() {
		return idpagamento;
	}
	public void setIdpagamento(int idpagamento) {
		this.idpagamento = idpagamento;
	}
	public String getNomecartao() {
		return nomecartao;
	}
	public void setNomecartao(String nomecartao) {
		this.nomecartao = nomecartao;
	}
	public String getNumerocartao() {
		return numerocartao;
	}
	public void setNumerocartao(String numerocartao) {
		this.numerocartao = numerocartao;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public String getExpiracao() {
		return expiracao;
	}
	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}
	public int getCodseguranca() {
		return codseguranca;
	}
	public void setCodseguranca(int codseguranca) {
		this.codseguranca = codseguranca;
	}
	
}
