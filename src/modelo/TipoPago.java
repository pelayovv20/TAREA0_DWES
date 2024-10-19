package modelo;

import java.util.Objects;

public enum TipoPago{
	efectivo('E',"efectivo"),
	transferencia('T',"transferencia"),
	tarjeta_credito('C',"tarjeta de crédito");
	
	private char codigo;
	private String nombre;
	
	TipoPago(char codigo,String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public char getCodigo() {
		return codigo;
	}

	public void setCodigo(char codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}