package Recursividad.src.recursividad.ejemplo4;

public class ReinasRecursividad {



	public static int backtrackReinas(int[] tablero, int r){
		int c;
		int soluciones=0;

		if(r==Reinas.N)
			return 1;
		for(c=0;c<Reinas.N;c++){

			if(!Reinas.esComida(r, c,tablero)){

				tablero[r]=c;
				soluciones+= backtrackReinas(tablero,r+1);
				tablero[r]=0;
			}

		}
		return soluciones;
	}
	public static void main(String[] arg){

		int[] tablero = new int[Reinas.N];
		System.out.println("Recursividad:"+backtrackReinas(tablero,0));	
	}

}
