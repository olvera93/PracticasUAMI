package recursividad.ejemplo1;

public class Aproximacion {


	static int factorial(int n) {

		if(n==0 || n==1)
			return 1;
		return n*factorial(n-1);

	}

	static double potencia(double  a, int b) {

		if(b==0)
			return 1;
		return a*potencia(a,b-1);

	}


	static double aproximacion(int n, double x) {

		if(n==0)
			return 1;
		return potencia(x,n)/factorial(n)+aproximacion(n-1,x);


	}


	public static void main(String[] args) {

		int n=0;
		double x=0.0;

		boolean continuar=true;
		do {
			try {
				n = Integer.parseInt(args[0]);
				x = Integer.parseInt(args[1]);

				System.out.println("Aproximacion n:"+n+" x:"+x+": "+aproximacion(n,x));
				continuar=false;
			}catch(NumberFormatException e) {

				System.out.println("Ingresa un x o y correcto!");

			}
		}while(continuar);

	}	

}
