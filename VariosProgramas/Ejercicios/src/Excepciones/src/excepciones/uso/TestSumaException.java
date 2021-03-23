package excepciones.uso;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TestSumaException {
	static final int N = 3;

	public static void main ( String[] a ) 
	{
		int numero,total=0,suma=0;
		Scanner scan = new Scanner(System.in);

		while(total<N){

			try{
				while(total<N){		
					System.out.print("Ingresa  aun entero: ");
					numero = scan.nextInt();
					suma = suma + numero;
					total++;
				}
			}catch(InputMismatchException e){

				scan = new Scanner(System.in);

			}
		}     
		System.out.println("Resultado:"+suma);
		scan.close();
	}
}