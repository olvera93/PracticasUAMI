package recursividad;

import static recursividad.MetodosRecursivos.*;
import static recursividad.TorresDeHanoi.mostrarMovimientos;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
        System.out.println("\tPractica 6");
        System.out.println("Factorial de 4 es: "+factorial(4));
        System.out.println("Potencia de 2^4: "+potencia(2,4));
        System.out.println("Fibonacci de 10 es: "+fibonacci(10));
        String items[] = {"Ana","Beto","Carlos","Mario"};
        System.out.println("Carlos esta en la posicion: "+ busquedaLineal(items,"Carlos"));
        
        System.out.println("\nTorre de Hannoi");
        String resultado = mostrarMovimientos(3,'I','D','T');
        System.out.println( ++n +resultado);
	}

}
