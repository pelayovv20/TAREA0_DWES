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
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
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
		clientes.add(nuevoCliente);
		
		nuevoCliente.setNotificaciones(notificaciones);
		
		String año;
		int numeroAño = 0;
		
		do {
			System.out.println("Introduce el año de la notificación: ");
			año = in.nextLine();
		}while (!año.matches("^\\d{4}$"));
		
		numeroAño = Integer.parseInt(año);
		
		int[] notificacionesMes = nuevoCliente.notificacionesEn(numeroAño);
		System.out.println("Notificaciones del año " + numeroAño + " : ");
		for (int i=0;i<notificacionesMes.length;i++) {
			System.out.println("Mes " + (i+1) + ": " + notificacionesMes[i] + " notifiaciones ");
		}
		
		System.out.println();
		
		
		modelo.Documentacion nif_1 = new modelo.NIF("53522455", 'Y');
		modelo.Documentacion nif_2 = new modelo.NIF("00133590", 'Y');
		modelo.Documentacion nif_3 = new modelo.NIF("39490988", 'B');
		
		Cliente c1 = new Cliente(nif_1,"Pelayo Vázquez Vidal","Avenida la Costa","657298814",
				Date.valueOf("2005-07-09"),true,TipoPago.tarjeta_credito,new ArrayList<Notificacion>());
		
		Cliente c2 = new Cliente(nif_2,"Amador Rivas","Calle Ave del Paraíso","609304489",
				Date.valueOf("2000-03-20"),true,TipoPago.transferencia,new ArrayList<Notificacion>());
		
		Cliente c3 = new Cliente(nif_3,"Yolanda Morcillo","Calle La Cuesta","603877732",
				Date.valueOf("1995-09-01"),false,TipoPago.efectivo,new ArrayList<Notificacion>());
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		
			Cliente.infoClientes(clientes);
		
		
		
	}

}
