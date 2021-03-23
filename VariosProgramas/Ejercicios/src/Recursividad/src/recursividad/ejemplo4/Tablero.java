package recursividad.ejemplo4;

public class Tablero {

	
	private int[] tablero= new int[Reinas.N];
	private int r;
	
	Tablero(int r, int[] t){
		
		this.r=r;
		this.tablero=t.clone();
		
	}

	public int[] getTablero() {
		return tablero;
	}

	public void setTablero(int[] tablero) {
		this.tablero = tablero;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	
	
}
