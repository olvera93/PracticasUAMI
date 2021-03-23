package mx.uam.izt.apaloo.p1.calculadora;

public class Calculadora {
	
	private Pantalla pantalla;
    private Teclado teclado;
    private Procesador procesador;
        
	public Calculadora() {
		this.pantalla = new Pantalla();
		this.teclado = new Teclado();
		this.procesador = new Procesador();
	}
    	
	public void on() {
		
		System.out.println("\nCalculadora encendida\n");
		char op;
		Complejo res;
		

		do {
			switch(op=teclado.capturaOper()) {
				case '+':
					System.out.println(" SUMA ");
					Complejo a = teclado.getCapturaNumero();
					Complejo b = teclado.getCapturaNumero();
					res=procesador.sumar(a,b);
					pantalla.imprimirNumero(res);
				break;	
				
				case '-':
					System.out.println(" RESTA ");
					Complejo c = teclado.getCapturaNumero();
					Complejo d= teclado.getCapturaNumero();
					res= procesador.restar(c, d);
					pantalla.imprimirNumero(res);
				break;	
				
				case '*':
					System.out.println(" MULTIPLICACION ");
					Complejo e = teclado.getCapturaNumero();
					Complejo f= teclado.getCapturaNumero();
					res= procesador.restar(e, f);
					pantalla.imprimirNumero(res);
				break;
				
				case '/':
					System.out.println(" DIVISION ");
					Complejo g = teclado.getCapturaNumero();
					Complejo h = teclado.getCapturaNumero();
					res= procesador.restar(g, h);
					pantalla.imprimirNumero(res);
				break;
				
				case 's':
					hacersumaM();
				break;
				
				case 'm':
					hacermultiM();
				break;	
				
				case 'o':
					System.out.println("\nApagando calculadora\n");
				break;
				
				default:
					System.out.print("\nEsa opcion no existe\nt");
				break;
			}
			
		}while(op!='o');
				
	}
	
	private void hacersumaM() {
		
		System.out.println(" SUMA M");
		String archivo = teclado.capturaNombre();
		int m= teclado.capturaDim();
		int n= teclado.capturaDim();
		Complejo [][] A=teclado.capturaMatriz(archivo,m,n);
		//capturar matriz A
		String archivo2 = teclado.capturaNombre();
		int p = teclado.capturaDim();
		int q = teclado.capturaDim();
		Complejo [][] B= teclado.capturaMatriz(archivo2, p, q);
		//captura matriz B
		Complejo[][] res1 = procesador.sumarM(A,B,m,n);
		pantalla.imprimirM(res1,m,n);
		
	}
	
	private void hacermultiM() {
		System.out.println(" MULTIPLICACION M");
		String archivo = teclado.capturaNombre();
		int m= teclado.capturaDim();
		int n= teclado.capturaDim();
		Complejo [][] A=teclado.capturaMatriz(archivo,m,n);  // Captura matriz A
		String archivo2 = teclado.capturaNombre();
		int p = teclado.capturaDim();
		int q = teclado.capturaDim();
		Complejo [][] B= teclado.capturaMatriz(archivo2, p, q);// Captura matriz B
		Complejo[][] res1 = procesador.multiM(A,B,m,q);
	
		pantalla.imprimirM(res1,m,q);
		
	}

}
