package modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import utils.Utilidades;

public class Cliente implements Serializable {

	private Documentacion id;
	private String nombre;
	private String direccion;
	private String telefono;
	private Date fechaNac;
	private boolean suscripcion;
	
	private TipoPago pagoPref=TipoPago.efectivo;
	
	private ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();
			
	
	public Cliente() {
		
	}


	public Cliente(Documentacion id, String nombre, String direccion, String telefono, Date fechaNac,
			boolean suscripcion, TipoPago pagoPref, ArrayList<Notificacion> notificaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.suscripcion = suscripcion;
		this.pagoPref = pagoPref;
		this.notificaciones = notificaciones;
	}


	public Documentacion getId() {
		return id;
	}


	public void setId(Documentacion id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public boolean isSuscripcion() {
		return suscripcion;
	}


	public void setSuscripcion(boolean suscripcion) {
		this.suscripcion = suscripcion;
	}


	public TipoPago getPagoPref() {
		return pagoPref;
	}


	public void setPagoPref(TipoPago pagoPref) {
		this.pagoPref = pagoPref;
	}


	public ArrayList<Notificacion> getNotificaciones() {
		return notificaciones;
	}


	public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", fechaNac=" + fechaNac + ", suscripcion=" + suscripcion + ", pagoPref=" + pagoPref
				+ ", notificaciones=" + notificaciones + "]";
	}
	
	
	
	public static Cliente nuevoCliente() {
		Scanner in = new Scanner (System.in);
		Documentacion id = null;
		String nombre;
		String direccion;
		String telefono;
		LocalDate fechanac = null;
		boolean suscripcion = false;
		TipoPago pagoPref = TipoPago.efectivo;
		
		//VALIDACION TIPO DE DOCUMENTO DE IDENTIFICACION
		
		String tipoDocumento;
		String numeroDocumento;
		
		System.out.println("IDENTIFICACION");
		System.out.println();
		do {
			System.out.println("Tu documento es NIF o NIE");
			tipoDocumento = in.nextLine().toUpperCase();
			
			
		}while(!tipoDocumento.equals("NIE") || !tipoDocumento.equals("NIF"));
		
		boolean valido = false;
		do {
			System.out.println("Introduce el numero de identificacion: ");
			numeroDocumento=in.nextLine();
			if (tipoDocumento.equals("NIE")) {
				NIE nie = new NIE(numeroDocumento.substring(1,8),numeroDocumento.charAt(0),numeroDocumento.charAt(8));
				if (nie.validar()) {
					id = nie;
					valido = true;
				}else {
					System.out.println("NIE no válido");
				}
			}else if (tipoDocumento.equals("NIF")) {
				NIF nif = new NIF(numeroDocumento.substring(0,8),numeroDocumento.charAt(8));
				if (nif.validar()) {
					id = nif;
					valido = true;
				}else {
					System.out.println("NIF no válido");
				}
			}
		}while(!valido);
		
		System.out.println();
		
		
		//NOMBRE DEL CLIENTE
		System.out.println("NOMBRE DEL CLIENTE: ");
		nombre = in.nextLine();
		
		//DIRRECION DEL CLIENTE
		System.out.println("DIRRECION DEL CLIENTE: ");
		direccion = in.nextLine();
		
		//TELEFONO DEL CLIENTE
		valido = false;
		do {
			System.out.println("Introduce tu número de teléfono: ");
			telefono = in.nextLine();
			if (!telefono.matches("[6-7-9][0-9]{8}")){
				System.out.println("TELEFONO no válido");
				valido = false;
			}else {
				System.out.println("TELEFONO introducido");
				valido = true;
			}
		}while(!valido);
		
		//FECHA DE NACIMIENTO DEL CLIENTE
		valido = false;
		
		
		do {
			System.out.println("Dame la fecha de nacimiento: ");
			fechanac = Utilidades.leerFecha();
			if (fechanac.isAfter(LocalDate.now().minusYears(18))) {
				System.out.println("La fecha de nacimiento no pueded ser posterior a hoy");
			}else {
				valido = true;
			}
		}while (!valido);
		
		//SUSCRIPCION DEL CLIENTE
		valido = false;
		do {
			System.out.println("Tienes suscripcion(S/N): ");
			suscripcion = Utilidades.leerBoolean();
			valido = true;
		}while (!valido);
		
		//TIPO DE PAGO DEL CLIENTE
		valido = false;
		do {
			System.out.println("Introduce tu tipo de pago: (E: efectivo / T: transferencia / C: tarjeta de crédito ");
			char opcionPago = in.nextLine().toUpperCase().charAt(0);
			switch (opcionPago) {
			case 'E':
				pagoPref = TipoPago.efectivo;
				valido = true;
				break;
			case 'T':
				pagoPref = TipoPago.transferencia;
				valido = true;
				break;
			case 'C':
				pagoPref = TipoPago.tarjeta_credito;
				valido = true;
				break;
			default:
				System.out.println("Tipo de pago incorrecto");
			}
		}while (!valido);
		
		
		System.out.println();
		
	
		
	return new Cliente(id,nombre,direccion,telefono,Date.valueOf(fechanac),suscripcion,pagoPref,new ArrayList<Notificacion>());
	
		
	
		
	}
	
	public static void infoClientes(ArrayList<Cliente> clientes) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt"))){
			for (Cliente c:clientes) {
				String informacion = c.getNombre() + c.getId() + c.getFechaNac() + " Tfno: " + c.getTelefono() + " Dir: " + c.getDireccion();
				writer.write(informacion);
				writer.newLine();
			}
			System.out.println("Fichero clientes.txt");
		}catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public int[] notificacionesEn(int año) {
        int[] notificacionesMes = new int[12];
        for (Notificacion notificacion : notificaciones) {
            
            if (notificacion.getFecha().getYear() == año) {
                int mes = notificacion.getFecha().getMonthValue();
                notificacionesMes[mes]++;
            }
        }

        return notificacionesMes;

}
	
	
	
	
	
	
	
	
	
	
	
	
}
