package BackTrack;
import BackTrack.Laberinto;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laberinto la = new Laberinto();
		System.out.println("Laberinto generado:");
		boolean sol;
		la.imprimirLaberinto();
		
		sol = la.encontrarElCamino(0,0);
		System.out.println("\nSe encontro la solucion\n"+sol);
		System.out.println("Resultado\n");
		la.imprimirLaberinto();
		}


}
