package recursividad.ejemplo4;

import java.util.LinkedList;

public class Reinas {


	public static final int N=13;

	static boolean esComida(int reng, int col, int[] Tablero){
		int i,j;
		boolean comida=true;


		i=reng-1;
		while ( (i>=0) && (Tablero[i]!=col)) /* verifica columna*/
			i--;
		if(i < 0){  
			i=reng-1;
			j=col-1;
			while ( (i>=0) && (j>=0) && (Tablero[i]!=j)){ 
				i--; 
				j--; 
			}         /*verifica diagonal izquierda (\)*/
			if( (i<0) || (j < 0)){ 
				i=reng-1;
				j=col+1;
				while ( (i>=0) && (j<=N) && (Tablero[i]!=j) ){ 
					i--; 
					j++; 
				}         /*verifica diagonal derecha (/) */
				if( (i<0) || (j > N))
					comida = false;
			}
		}
		return (comida);
	}


	static int reinasIterativo(){

		LinkedList<Tablero>  l = new LinkedList<Tablero>();
		int[] tablero = new int[N];
		Tablero aux;

		int r=0;
		int soluciones=0;

		l.add(0,new Tablero(0,tablero));

		while(!l.isEmpty()){

			aux = l.remove();
			tablero = aux.getTablero();
			r = aux.getR();
			if(r==(N)){
				soluciones++;
			}else
				for(int c=0;c<N;c++){

					if(!esComida(r, c,tablero)){

						tablero[r]=c;
						l.add(0,new Tablero(r+1,tablero));

					}
				}
		}
		return soluciones;

	}


	public static void main(String[] args){


		System.out.println("Iterativo:"+Reinas.reinasIterativo());

	}

}