package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class NEmail extends Notificacion {

	private String direccion;
	
	public NEmail() {
		
	}

	public NEmail(Long id, LocalDate fecha, String mensaje,String direccion) {
		super(id, fecha, mensaje);
		this.direccion=direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(direccion);
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
		NEmail other = (NEmail) obj;
		return Objects.equals(direccion, other.direccion);
	}

	@Override
	public String toString() {
		return "NEmail [direccion=" + direccion + "]";
	}
	
	
	
}
