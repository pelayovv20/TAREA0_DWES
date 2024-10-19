package principal;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Notificacion;
import modelo.TipoPago;

public class Principal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();
		
		notificaciones.add(new Notificacion(1L,LocalDate.of(2024, 10, 21),"Ejercicio hecho"));
		notificaciones.add(new Notificacion(2L,LocalDate.of(2024, 3, 1),"Tarea de diseño hecha"));
		notificaciones.add(new Notificacion(3L,LocalDate.of(2024, 4, 23),"Examen de programación aprobado"));
		notificaciones.add(new Notificacion(4L,LocalDate.of(2024, 3, 7),"Tarea de entornos realizada"));
		notificaciones.add(new Notificacion(5L,LocalDate.of(2024, 1, 28),"Examen de JavaScript programado"));
		notificaciones.add(new Notificacion(6L,LocalDate.of(2024, 7, 9),"Proyecto en curso"));
		notificaciones.add(new Notificacion(7L,LocalDate.of(2024, 12, 25),"Ejercicio de programación hecho"));
		notificaciones.add(new Notificacion(8L,LocalDate.of(2024, 12, 31),"Proyecto acabado"));
		
		
		Cliente nuevoCliente = Cliente.nuevoCliente();
		System.out.println();
		System.out.println(nuevoCliente);
		
		
		nuevoCliente.setNotificaciones(notificaciones);
		
		
		
		
		
		
	}

}
