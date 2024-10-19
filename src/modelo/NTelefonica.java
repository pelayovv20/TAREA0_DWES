package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class NTelefonica extends Notificacion {

	private String numero;
	
	public NTelefonica() {
		
	}

	public NTelefonica(Long id, LocalDate fecha, String mensaje,String numero) {
		super(id, fecha, mensaje);
		this.numero=numero;
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NTelefonica other = (NTelefonica) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "NTelefonica [numero=" + numero + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
