package recursividad.ejemplo2;

public class Puntos {


	static int caminos(int x, int y) {

		if(x==0 && y ==0)
			return 1;
		else {

			if(x<0 || y<0)
				return 0;
			else
				return caminos(x-1,y)+caminos(x,y-1);

		}
	}

	public static void main(String[] args) {

		int x=0,y=0;
		boolean continuar=true;
		do {
			try {
				x = Integer.parseInt(args[0]);
				y = Integer.parseInt(args[1]);
				
				System.out.println("Caminos de ("+x+","+y+") a (0,0): "+caminos(x,y));
				continuar=false;
			}catch(NumberFormatException e) {

				System.out.println("Ingresa un x o y correcto!");

			}
		}while(continuar);

	}
}
