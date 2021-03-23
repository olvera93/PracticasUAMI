package exepciones.creacion.lanzar;


public class Calculadora {

	public static double sumar(double op1, double op2){
		double suma = op1 +op2;

		return suma;
	}
	public static double restar(double op1, double op2){
		double restar = op1 +op2;

		return restar;
	}

	public static double division(double op1, double op2) throws ArithmeticException {
		
		if(op2==0.0)
			throw new ArithmeticException();
		else
			return op1/op2;
				
	}
	
}

