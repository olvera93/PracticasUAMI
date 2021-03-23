package p6;

public class NodoAR {

	int dato;
	NodoAR izq;
	NodoAR der;
	static String cad = "";
	NodoAR()
	{}
	

	public NodoAR (int dato,NodoAR izq, NodoAR der) {
		this.dato=dato;
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


public static String order(NodoAR aux) {
		
		if(aux != null) {
			order(aux.izq);
			cad = String.valueOf(cad) + aux.dato + " ";
			order(aux.der);
		}
		return cad;
		
	}
	
	public static String postorder(NodoAR aux) {
		
		if(aux != null) {	
			postorder(aux.izq);
			postorder(aux.der);
			cad = String.valueOf((cad) + aux.dato + " ");
		}
		return cad;
	}
	
	public static String preOrder(NodoAR aux) {
		
		if(aux != null) {
			cad = String.valueOf(cad) + aux.dato + " ";
			preOrder(aux.izq);
			preOrder(aux.der);
		}
		return cad;
	}
	
   public static int nodoRaiz(NodoAR aux) {
		if(aux != null) {
			return aux.dato;
		}
		return -1;
	}

}
