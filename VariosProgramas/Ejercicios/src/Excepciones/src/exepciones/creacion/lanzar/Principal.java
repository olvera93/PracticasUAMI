package exepciones.creacion.lanzar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		double op1=0.0,op2=0.0;
		Scanner entrada = new Scanner(System.in);
		boolean continuar=false;
		do {
			try {

				System.out.print("Ingresa primer operador:");
				op1=entrada.nextDouble();
				System.out.print("Ingresa segundo operador:");
				op2=entrada.nextDouble();
				try {
					System.out.println("Resultado:"+Calculadora.division(op1,op2));
					continuar=false;
				} catch (ArithmeticException e) {
					//e.printStackTrace();
					System.out.println("Error division entre 0!");
					continuar=true;
				}	


			}catch(InputMismatchException e) {
				System.out.println("Ingresa datos numericos!");
				entrada.nextLine();
				continuar=true;
			}

		}while(continuar);
		entrada.close();
	}

}
