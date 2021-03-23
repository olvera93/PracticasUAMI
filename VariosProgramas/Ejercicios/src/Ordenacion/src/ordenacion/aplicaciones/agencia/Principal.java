package ordenacion.aplicaciones.agencia;

import java.util.Arrays;

import ordenacion.metodos.Ordenacion;

public class Principal {

	public static void main(String[] args) {
		
		Automovil[] bodega = new Automovil[7];
		
		bodega[0]=new Automovil("Kia", "Rio", 2017, 3.5, 4);
		bodega[1]=new Automovil("Ford", "Focus", 2016, 3.6, 6);	
		bodega[2]=new Automovil("VW", "Beattle", 2015, 2.6, 4);		
		bodega[3]=new Automovil("Kia", "Forte", 2018, 3.5, 4);
		bodega[4]=new Automovil("Chevrolet", "Chevy", 2018, 2.5, 4);	
		bodega[5]=new Automovil("Toyota", "Prius", 2017, 2.5, 4);
		bodega[6]=new Automovil("Kia", "Forte", 2017, 3.5, 4);

		
		Ordenacion.insercion(bodega);
		
		System.out.println(Arrays.toString(bodega));
		
		
	}

}

