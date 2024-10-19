package modelo;

import java.util.Objects;

public class NIE extends Documentacion {
	
	private String numero;
	private char letraInicial;
	private char letraFinal;
	
	public void NIE() {
		
	}
	
	

	public NIE(String numero,char letraInicial,char letraFinal) {
		super();
		this.numero = numero;
		this.letraInicial = letraInicial;
		this.letraFinal = letraFinal;
	}
	
	



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public char getLetraInicial() {
		return letraInicial;
	}



	public void setLetraInicial(char letraInicial) {
		this.letraInicial = letraInicial;
	}



	public char getLetraFinal() {
		return letraFinal;
	}



	public void setLetraFinal(char letraFinal) {
		this.letraFinal = letraFinal;
	}
	
	
	

	@Override
	public String toString() {
		return "NIE [numero=" + numero + ", letraInicial=" + letraInicial + ", letraFinal=" + letraFinal + "]";
	}



	@Override
	public boolean validar() {
		return numero !=null && numero.matches("[XYZ]\\d{7}[A-Z]");

	}

	@Override
	public void mostrar() {
		
		System.out.println("NIE: " + letraInicial + numero + letraFinal);
	}

}
