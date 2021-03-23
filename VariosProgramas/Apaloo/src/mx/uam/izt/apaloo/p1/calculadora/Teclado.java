package mx.uam.izt.apaloo.p1.calculadora;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Teclado {
	
	public char capturaOper() {
		Scanner sc = new Scanner(System.in);
		char oper;
		System.out.println("\n\t¿Que opcion desea hacer?\n");
		System.out.println("\tSuma......+");
		System.out.println("\tResta......-");
		System.out.println("\tMultiplicacion......*");
		System.out.println("\tdivision....../");
		System.out.println("\tSuma M......s");
		System.out.println("\tMultiplicacion M......m");
		System.out.println("\tApagar......off");
		
		System.out.print("\n\tSu respuesta es: ");
		oper= sc.next().charAt(0);
			
		return oper;
		
	}
	
	public Complejo getCapturaNumero() {
        Scanner sc = new Scanner(System.in);
        Complejo num = new Complejo(); 
        
        System.out.print("\nParte real: ");
        num.setReal(sc.nextFloat());
        System.out.print("Parte imag: ");
        num.setImag(sc.nextFloat());
        
        return num;
    }
	
	public String capturaNombre() {
		Scanner sc = new Scanner(System.in);
		String nom = new String();
		
		System.out.print("Dame el nombre del archivo: ");
		nom=sc.nextLine();
		
		return nom;
		
	}
	
	public int capturaDim() {
		Scanner sc = new Scanner(System.in);
		int di = 0;		
		
		System.out.print("Dame la dimension: ");
		di=sc.nextInt();
		
		return di;
		
		
	}
	
	
	Complejo[][] capturaMatriz(String nombre, int m, int n){
		Complejo[][] M = new Complejo[m][n];
		Complejo c;
		try {
			File f = new File("C:/Users/olver/Desktop/Apaloo/src/mx/uam/izt/apaloo/p1/calculadora/"+nombre); //  /home/invitado/Escritorio/Apaloo/src/mx/uam/izt/apaloo/p1/calculadora/
			Scanner sc = new Scanner(f);
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					c = new Complejo(sc.nextFloat(),sc.nextFloat());
					M[i][j] = c;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se puede abrir");
			}
			return M;
			
	}

}
