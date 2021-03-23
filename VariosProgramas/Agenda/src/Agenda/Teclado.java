package Agenda;

import java.util.Scanner;

public class Teclado {
	
	public char capturaOpcion() {
		Scanner sc = new Scanner(System.in);
		char op;
		System.out.println("\n\t¿Que opcion desea ejecutar?");
		System.out.println("\tAgregar usuario..... +");
		System.out.println("\tMostrar todos los contactos.... t");
		System.out.println("\tBuscar usuario..... b");
		System.out.println("\tEliminar usuario..... -");
		System.out.println("\tModificar....... M");
		System.out.println("\tApagar............. o");
		
		System.out.print("\n\tSu respuesta es: ");
		op = sc.next().charAt(0);
		
		return op;
		
	}
	
	public Entrada capturaContacto() {
		String nombre;
		String telefono;
		Entrada E = new Entrada();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNombre del contacto: ");
		nombre = sc.nextLine();
		System.out.print("Telefono : ");
		telefono = sc.nextLine();
		
		E.setNombre(nombre);
		E.setTelefono(telefono);
		return E;	
	}
}
