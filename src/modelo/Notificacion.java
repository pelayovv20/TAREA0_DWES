package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Notificacion {

	protected Long id;
	protected LocalDate fecha=LocalDate.now();
	protected String mensaje;
	
	
	
	public Notificacion() {
		
	}



	public Notificacion(Long id, LocalDate fecha, String mensaje) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public String getMensaje() {
		return mensaje;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	@Override
	public String toString() {
		return "Notificacion [id=" + id + ", fecha=" + fecha + ", mensaje=" + mensaje + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, mensaje);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacion other = (Notificacion) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(mensaje, other.mensaje);
	}
	
		
	
}
