package excepciones.uso;


public class Ejemplo2 {

	public static void main(String argv[]){
		double datos[] = new double[10];
		try{
			datos[12] = 10.0;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error:  se trata de acceder a un indice incorrecto");


		}
		System.out.println("Continuo :)");
	}
}
