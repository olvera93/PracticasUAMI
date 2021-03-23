package recursividad.ejemplo3;

/**
 * Se utiliza el estándar de Oracle
 * @author Jose Luis Quiroz Fabian
 *
 */


import java.awt.Color;

import recursividad.libreria.StdDraw;

public class FractalH implements Figura{


	FractalH(){

		dibujar();
	}

	@Override
	public void dibujar() {

		double coordenadaX = 0.5;
		double coordenadaY = 0.5;      /*Centro de la figura*/
		double tam = 0.5;              /*Tamaño de cada lado*/ 

		calcularPosiciones(1,coordenadaX,coordenadaY,tam);

	}

	void dibujarH(double coordenadaX, double coordenadaY, double tam) {

		double x0 = coordenadaX - tam/2;
		double x1 = coordenadaX + tam/2;
		double y0 = coordenadaY - tam/2;
		double y1 = coordenadaY + tam/2;

		/*Se dibuja la H*/

		StdDraw.line(x0, y0, x0, y1);                        /*Parte izquierda*/
		StdDraw.line(x1, y0, x1, y1);                        /*Parte derecha*/
		StdDraw.line(x0,  coordenadaY, x1,  coordenadaY);    /*Conexion*/

	}

	void calcularPosiciones(int n, double coordenadaX, double coordenadaY, double tam) {
		if (n != 0){ 


			dibujarH(coordenadaX, coordenadaY, tam);

			/*Se calculan las nuevas coordenadas para cada extremo*/
			double x0 = coordenadaX - tam/2;
			double x1 = coordenadaX + tam/2;
			double y0 = coordenadaY - tam/2;
			double y1 = coordenadaY + tam/2;

			/*Se realiza el dibujo recursivamente*/
			StdDraw.setPenColor(Color.BLUE);
			calcularPosiciones(n-1, x0, y0, tam/2);     /*Parte izquierda baja*/
			StdDraw.setPenColor(Color.RED);
			calcularPosiciones(n-1, x0, y1, tam/2);     /*Parte izquierda alta*/
			StdDraw.setPenColor(Color.GREEN);
			calcularPosiciones(n-1, x1, y0, tam/2);     /*Parte derecha baja*/
			StdDraw.setPenColor(Color.ORANGE);
			calcularPosiciones(n-1, x1, y1, tam/2);     /*Parte derecha alta*/
		}	
	}

	public static void main(String[] args) {

		new FractalH();
	}

}
