package Agenda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
	
	private Teclado t = new Teclado ();
	private ApalooLinkedList <Entrada> list = new ApalooLinkedList<>();
	
	public void on() {
		char op;
		
		do {
			switch(op = t.capturaOpcion() ) {
			
				case '+':
					agregarContacto();
				break;
				
				case 't':
					mostrarContactos();
				break;
				
				case 'b':
					buscarContacto();
					
				break;
				
				case '-':
					eliminarContacto();
					
				break;
				
				case 'M':
					modificarContacto();
				break;
				
				case 'o':
					System.out.println("Adios");
				break;
				
				default:
					System.out.println("No existe esa opción");
				break;
			}
			
			
		}while(op!='o');
	}
	
	private void agregarContacto (){
		System.out.println("\nAgregando contacto..");
		Entrada E = t.capturaContacto();
		list.add(E);
	}
	
	private void mostrarContactos() {
		System.out.println("\n\t CONTACTOS");
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print("\n\tNombre:  "+list.get(i).nombre + "\n\t" + "Telefono: "+list.get(i).telefono +"\n");
			
		}
	}
	
	private void buscarContacto() {
		Scanner sc = new Scanner(System.in);
		String nombre;
		System.out.print("\nContacto a buscar: ");
		nombre = sc.nextLine();
		int index = list.indexOf(new Entrada(nombre));
		try {
			if(list.get(index).nombre.equals(new Entrada(nombre))) {
			System.out.println("El contacto no existe");
			}else {
			System.out.print("\tEl contacto es: "+list.get(index).nombre+"\n");
			System.out.print("\tEl telefono es: "+list.get(index).telefono+"\n");
			System.out.print("\n\tPocicion de la lista: "+ index+"\n");
			}
		}catch (Exception e) {
			System.out.println("El contacto no existe");
		}
	}
	
	
	private void eliminarContacto() {
		System.out.println("\nEliminando contacto..");
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		System.out.print("Contacto a eleminar: ");
        nombre = sc.nextLine();
		int index = list.indexOf(new Entrada(nombre,""));
		try {
			if(list.get(index).nombre.equals(new Entrada(nombre))) {
				System.out.println("El contacto no esta en la agenda");

			}else {
				list.remove(index);
				System.out.println("\nEl contacto fue eliminado");
				mostrarContactos();
            }
		}catch (Exception e) {
			System.out.println("El contacto no existe");
		}
		
	}
	
	
	private void modificarContacto() {
		System.out.print("\nModificar contacto..");
		Scanner sc = new Scanner(System.in);
		String nombre ="" ;
		System.out.print("\nContacto a modificar: ");
		nombre = sc.nextLine();
		int index = list.indexOf(new Entrada(nombre,""));
		try {
			if(list.get(index).nombre.equals(new Entrada(nombre))) {
				System.out.println("El nombre esta mal escrito");
			}else {
				Entrada nombre1 = t.capturaContacto();
				System.out.println(list.set(index,nombre1));
				mostrarContactos();
			}
		}catch (Exception e) {
			System.out.println("El contacto no existe");
		}
		
	}
	 
		
}
	



