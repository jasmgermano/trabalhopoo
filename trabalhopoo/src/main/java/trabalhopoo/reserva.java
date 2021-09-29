package trabalhopoo;

import java.time.LocalDate;
import java.util.Date;

public class reserva {
	private int idReserva;
	private String status;
	private float valor;
	private LocalDate checkin;
	private LocalDate checkout;
	private String rg;
	private int numquarto;

	public reserva(int idReserva, String status, float valor, LocalDate checkin,
			LocalDate checkout, int numquarto, String rg) {
		this.idReserva = idReserva;
		this.status = status;
		this.valor = valor;
		this.checkin = checkin;
		this.checkout = checkout;
		this.numquarto = numquarto;
		this.rg = rg;
	}
	
	public reserva(LocalDate checkin, LocalDate checkout, int numquarto) {
		this.checkin=checkin;
		this.checkout=checkout;
		this.numquarto=numquarto;
	}
	
	public reserva(String rg) {
		this.rg=rg;		
	}


	
	public reserva() {
		
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public int getNumquarto() {
		return numquarto;
	}

	public void setNumquarto(int numquarto) {
		this.numquarto = numquarto;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	
}
