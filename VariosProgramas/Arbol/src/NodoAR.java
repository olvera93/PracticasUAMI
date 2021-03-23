

public class NodoAR {

	NodoAR izq;
	NodoAR der;
	char cad;
	NodoAR()
	{}
	

	public NodoAR (char cad,NodoAR izq, NodoAR der) {
		this.cad=cad;
		this.izq=izq;
		this.der=der;	
	}


	public static int cuentaElementos(NodoAR p) {
		if(p==null)
			return 0;
		else
			return 1+cuentaElementos(p.izq)+cuentaElementos(p.der);
	}


	static int max(int x, int y) {
		if(x>=y)
			return x;
		else 
			return y;
	}
	
	public static int altura(NodoAR p) {
		if(p==null)
			return -1;
		else
			return 1+max(altura(p.izq),altura(p.der));
	}


public static void orden(NodoAR aux) {
		
		if(aux != null) {
			
			orden(aux.izq);
			System.out.print(aux.cad + " ");;
			orden(aux.der);
		}
		
	}
	
	public static void postorder(NodoAR aux) {
		
		if(aux != null) {	
			postorder(aux.izq);
			postorder(aux.der);
			System.out.print(aux.cad + " ");;
		}
		
	}
	
	public static void preOrder(NodoAR aux) {
		
		if(aux != null) {
			System.out.print(aux.cad + " ");;
			preOrder(aux.izq);
			preOrder(aux.der);
		}
		
	}
	
   public static int returnRoot(NodoAR aux) {
		if(aux != null) {
			return aux.cad;
		}
		return -1;
	}

}
