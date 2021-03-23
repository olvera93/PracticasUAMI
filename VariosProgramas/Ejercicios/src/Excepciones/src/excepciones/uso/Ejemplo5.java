package excepciones.uso;

public class Ejemplo5{
	double datos[] = new double[10];

	void operacion()  throws ArrayIndexOutOfBoundsException{

		datos[12] = 10.0;

	}

	public static void main(String argv[]){

		Ejemplo5 ejem = new Ejemplo5();
		try{
			ejem.operacion();

		}catch(Exception e){

			System.out.println("Error:  se trata de acceder a un indice incorrecto");
		}
	}
}
