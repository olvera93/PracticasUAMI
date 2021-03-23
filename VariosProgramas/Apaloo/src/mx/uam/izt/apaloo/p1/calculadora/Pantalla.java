package mx.uam.izt.apaloo.p1.calculadora;

public class Pantalla {
	
	public void imprimirNumero(Complejo c) {
        System.out.println("\nEl resultado es: "+c.getReal() + "+" + c.getImag() + "i");
        Complejo.contadorResultado++;
        System.out.println("\nNumero de operaciones que hizo en total: "+Complejo.contadorResultado);

    }
	
	void imprimirM(Complejo[][] A, int m, int n) {
		System.out.println("\n\t MATRIZ RESULTANTE ");
		for(int i=0 ; i<m ; i++) {
			System.out.println("");
			for(int j=0 ; j<n ; j++) {
		        System.out.print("  "+A[i][j].getReal() + "+" + A[i][j].getImag() + "i ");
			}	
		}
		System.out.println();
	}


}
