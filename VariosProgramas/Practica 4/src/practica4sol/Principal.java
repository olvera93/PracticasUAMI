package practica4sol;

import java.util.Collections;
import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Solucion de la practica 4");
        
		/*ApalooDobleLL <Contacto> l = new ApalooDobleLL <>();
		
		l.add(0, new Contacto("b","553"));
		l.add(1, new Contacto("c","4334"));
		l.add(2, new Contacto("d","6565"));
		l.add(3, new Contacto("a","3454"));*/
		
		ListaOrdenada<Contacto> ll = new ListaOrdenada<>();
		ll.add(new Contacto("b","553"));
		ll.add(new Contacto("c","4334"));
		ll.add(new Contacto("d","6565"));
		ll.add(new Contacto("a","3454"));
			
		
		/*System.out.println("\nLISTA DESORDENADA\n");
		Contacto e1 = null;
		for(int i = 0 ; i < 4 ; i++) {
			e1 = l.get(i);
			System.out.println(e1.getNombre() + " : " + e1.getTelefono() );	
		}*/
		
		
		System.out.println("\nLISTA ORDENADA\n");
		for(Contacto c : ll) {
			System.out.println(c.getNombre() + " : " + c.getTelefono() );	
		}
	}
	

}
