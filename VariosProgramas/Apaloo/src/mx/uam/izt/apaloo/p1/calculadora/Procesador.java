package mx.uam.izt.apaloo.p1.calculadora;

public class Procesador {

	public Complejo sumar(Complejo a, Complejo b) {
        Complejo c = new Complejo();
        
        c.setReal( a.getReal() + b.getReal() );
        c.setImag( a.getImag() + b.getImag() );
        
        return c;
    }
	
	public Complejo restar(Complejo a, Complejo b) {
		Complejo r = new Complejo();
		
		r.setReal( a.getReal() - b.getReal() );
		r.setImag( a.getImag() - b.getImag() );
		
		return r;
		
	}
	
	public Complejo multiplicar(Complejo a, Complejo b) {
		Complejo m = new Complejo();
		
		m.setReal( (a.getReal() * b.getReal()) - (a.getImag() * b.getImag()) );
		m.setImag((a.getReal() * b.getImag()) + (a.getImag() * b.getReal() ) );
		
		return m;
		
	}
	
	public Complejo division(Complejo a, Complejo b) {
		Complejo d = new Complejo();
		
		d.setReal( (float) (((a.getReal() * b.getReal()) + (a.getImag() * b.getImag())) / (Math.pow(b.getReal(),2) + Math.pow(b.getImag(), 2))) );
		d.setImag( (float) (((a.getImag() * b.getReal()) - (a.getReal() * b.getImag())) / (Math.pow(b.getReal(),2) + Math.pow(b.getImag(), 2))) );
		
		return d;
		
	}
	
	public Complejo[][] sumarM(Complejo[][] A, Complejo[][] B, int m, int n){
		Complejo S1 [][] = new Complejo[m][n];
		Complejo c,aux;
		aux= new Complejo();

		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j< n ; j++) {
				aux= sumar(A[i][j],B[i][j]);
				c= new Complejo(aux.getReal(), aux.getImag());
				S1[i][j]= c;
			}
		}
		return S1;
		
	}
	
	public Complejo[][] multiM(Complejo[][] A, Complejo[][] B, int m, int n){
		Complejo M1 [][] = new Complejo[m][n];
		Complejo c,aux;
		aux= new Complejo();
		Complejo suma;
		
			for(int i=0 ; i < m ; i++) {
				for(int j=0 ; j < m ; j++) {
					suma= new Complejo(0,0);
					for(int k=0 ; k < n; k++ ) {
						aux= multiplicar(A[i][k],B[k][j]);
						c= new Complejo(aux.getReal(), aux.getImag());
						suma = sumar(c,suma);
						M1[i][j]=suma;
					}
				
				}		
			
			}
		
		return M1;		
	}
}
