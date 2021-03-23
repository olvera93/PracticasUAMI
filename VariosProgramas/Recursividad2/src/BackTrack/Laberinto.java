package BackTrack;

public class Laberinto {
	
	int FILS = 6;
	int COLS = 10;
	
	int [][] visitados = new int [FILS][COLS];

	int [][] laberinto = {{0,0,1,0,0,0,0,0,0,0}
	 					,{1,0,1,1,1,0,1,1,0,1}
	 					,{1,0,1,0,0,0,1,1,0,1}
						,{1,0,0,0,1,0,0,0,1,0}
						,{1,1,1,0,1,0,1,0,1,0}
						,{1,1,0,0,0,1,1,0,0,0}};
	
	  boolean encontrarElCamino(int fil , int col) {
		if((fil < 0 || fil >= FILS) || (col < 0 || col >= COLS )) {  //Esta fuera del laberinto.
			return false;
		}else if(laberinto[fil][col] == 1 || visitados [fil][col] == 1) { //Dice si es un bloque o ese lugar ya fue visitado.
				return false;
			}else if(fil == FILS-1 && col == COLS-1) { // Es la salida
				visitados[fil][col]= 1; // Marca que ya fue visitado.
				laberinto[fil][col]= 8; // Marca como parte del camino.
				return true;
			}else
				visitados[fil][col]= 1; //Marca que ya fue visitado.
				laberinto[fil][col]= 8; //Marca como parte del camino
				if(encontrarElCamino (fil-1,col) || encontrarElCamino (fil+1,col) || encontrarElCamino (fil,col-1) || encontrarElCamino (fil,col+1)) {
					return true;
				}else
					laberinto[fil][col]= 0; //Desmarca como parte del camino.
					return false;
	}
	
	 void imprimirLaberinto() {
		for(int i = 0 ; i < FILS ; i++) {
			for(int j = 0 ; j < COLS ; j++) {
				System.out.print("["+laberinto[i][j]+"]");
			}
			System.out.println("");
		}
	}
}
