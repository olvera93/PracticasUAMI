package excepciones.uso;
import java.util.Scanner;


public class TestSuma{

	static final int N = 3;

	public static void main ( String[] a ) {
		int numero,total=0,suma=0;
		Scanner scan = new Scanner(System.in);

		while(total<N){

			System.out.print("Ingresa  aun entero: ");
			numero = scan.nextInt();
			suma = suma + numero;
			total++;

		}
		scan.close();     
		System.out.println("Resultado:"+suma);
	}
}