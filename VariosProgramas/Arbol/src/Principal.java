

public class Principal {

	public static void main(String[] args) {
		String cadena="(A+B)/(C^D)";
		//String cadena="A+B";
		String aux=Pila.infija_Posfija(cadena);
		System.out.println(aux);
		
		NodoAR tree = Pila.arbolExpresion(aux);
		System.out.println(tree.izq);
		NodoAR.orden(tree);
		//Pila.arbolExpresion2(cadena);
	}


}
