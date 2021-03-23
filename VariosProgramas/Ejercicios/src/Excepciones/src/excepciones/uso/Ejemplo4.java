package excepciones.uso;

public class Ejemplo4 {


	public static void main(String argv[]){
		double datos[] = new double[10];
		@SuppressWarnings("unused")
		int x=0;
		try{
			datos[9] = 10.0;
			x = 5/0;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error:  Se trata de acceder a un indice incorrecto");

		}	
		catch(ArithmeticException e){

			System.out.println("Error: division entre cero");


		}finally{

			System.out.println("Siempre se ejecuta");

		}
	}
}
