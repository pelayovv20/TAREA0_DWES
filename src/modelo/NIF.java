package modelo;

import java.util.Objects;

public class NIF extends Documentacion {
	
	private String numero;
	private char letraFinal;
	
	public void NIF() {
		
	}
	
	

	public NIF(String numero,char letraFinal) {
		super();
		this.numero = numero;
		this.letraFinal = letraFinal;
		
	}
	
	



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public char getLetraFinal() {
		return letraFinal;
	}



	public void setLetraFinal(char letraFinal) {
		this.letraFinal = letraFinal;
	}


	

	

	@Override
	public String toString() {
		return "NIF [numero=" + numero + ", letraFinal=" + letraFinal + "]";
	}



	private static final String arrayLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	@Override
	public boolean validar() {
			if (numero != null || numero.matches("||d{8}")) {
				return false;
			}
			else {
				int resultado =Integer.parseInt(numero) % 23;
				char letra = arrayLetras.charAt(resultado);
				return letra == letraFinal;
			}

	}

	@Override
	public void mostrar() {
		System.out.println("NIF: " + numero + letraFinal);
		

	}

}
