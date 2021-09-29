package trabalhopoo;

public class quartos {
	private String tipoQuarto;
	private float valorDiaria;
	private int numQuarto;
	private float tamanho;
	private String descricao;
	
	public quartos(String tipoQuarto, float valorDiaria, int numQuarto, float tamanho, String descricao) {
		this.tipoQuarto = tipoQuarto;
		this.valorDiaria = valorDiaria;
		this.numQuarto = numQuarto;
		this.tamanho = tamanho;
		this.descricao = descricao;
	}
	
	public quartos() {
		
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
