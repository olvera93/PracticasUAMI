package ordenacion.aplicaciones.libreria;

import java.util.Arrays;

import ordenacion.metodos.Ordenacion;

public class Principal {

	public static void main(String[] args) {
		
		Libro[] bodega = new Libro[7];
		bodega[0]=new Libro("Joshua Bloch", "Effective Java", new Fecha(2001,12,1),"USA", "9780134686097");
		bodega[1]=new Libro("Bert Bates", "Head First Java", new Fecha(2003,1,1),"USA", "9780596009205");	
		bodega[2]=new Libro("Brian Goetz", "Java Concurrency in Practice", new Fecha(2006,5,1),"Europe", "B004V9OA84");		
		bodega[3]=new Libro("Bert Bates", "Head First Java", new Fecha(2003,1,1),"USA", "9780596009205");
		bodega[4]=new Libro("Bert Bates", "Head First Java", new Fecha(2003,1,1),"USA", "9780596009205");
		bodega[5]=new Libro("Jamie Chan", "Learn Java in One Day and Learn It Well", new Fecha(2016,10,1),"Canada", "1539397831");
		bodega[6]=new Libro("Jamie Chan", "Learn Java in One Day and Learn It Well", new Fecha(2018,10,1),"Canada", "1539397831");

		
		Ordenacion.insercion(bodega);
		
		System.out.println(Arrays.toString(bodega));
		
		
	}

}

