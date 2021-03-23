package Agenda;

import java.util.Random;
import java.util.Scanner;

public class Multi {
	
	
	static void producto(int[][] a,int[][] b) {
		int i,j,k;
		int result [][] = new int [a.length][b.length];
		
		for(i=0;i<a[0].length;i++) {
			for(j=0;i<b[0].length;j++) {
				for(k=0;k<a.length;k++) {
					result [i][j] +=(a[i][k])*(b[k][j]);
					
				}
				System.out.println(result[i][j]);
			}
		}
		
		
	}
	
	static void imprimemat(int[][] a) {
		int i, j;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[0].length; j++)
			System.out.print(a[i][j] + " ");
			System.out.println();

		}
		
		System.out.println();
	}
	

	public static void main(String[] args) {
		int r1,c1,r2,c2 ;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("A CONTINUACION HAREMOS UNA MULTIPLICACION DE MATRICES");
		System.out.println("INGRESE EL NUMERO DE RENGLONES PARA LA PRIMERA MATRIZ");
		r1=sc.nextInt();
		
		System.out.println("INGRESE EL NUMERO DE COLUMNAS PARA LA PRIMERA MATRIZ");
		c1=sc.nextInt();
		
		System.out.println("INGRESE EL NUMERO DE RENGLONES PARA LA SEGUNDA MATRIZ");
		r2=sc.nextInt();
		
		System.out.println("INGRESE EL NUMERO DE COLUMNAS PARA LA SEGUNDA MATRIZ");
		c2=sc.nextInt();
		int i, j;
		Random al = new Random();

		int[][] x = new int[r1][c1];
		int[][] y = new int[r2][c2];
		int[][] res = new int[r1][c2];
		
		if(c1==r2) {

		for (i = 0; i < x.length; i++)
			for (j = 0; j < x[i].length; j++)
				x[i][j] = al.nextInt(20) + 1;

		for (i = 0; i < y.length; i++)
			for (j = 0; j < y[i].length; j++)
				y[i][j] = al.nextInt(20) + 1;
		
		
		imprimemat(x);
		
		
		imprimemat(y);
		
		producto(x,y);
		
		imprimemat(res);
		}else {
			
			System.out.println("ERROR");
			System.out.println("El producto de dos matrices estará definido si el número de columnas en la primera matriz es igual al número de renglones en la segunda matriz.");
			
		}
		
		
	}


}
