package practica5sol;

/**
 * Clase para una lista simplemente ligada. NO implementa
 * la interfaz List de Java.
 * @param <E> Tipo de elemento a almacenar,
 */
 
public class PilaLinkedL<E> {

	private Nodo<E> tope = null;
	
	/**
     * Un nodo es un contenedor de un elemento de la lista ligada y 
     * una referencia o link al nodo siguiente
     * @param <E> Es el tipo de elemento que almacena la lista
     */

    
    private static class Nodo<E> {
        private E datos;
        private Nodo<E> sig;
        
        private Nodo(E datos){
            this.datos = datos;
            this.sig = null;
        }
        
        private Nodo(E datos, Nodo<E> nodo){
            this.datos = datos;
            this.sig = nodo;
        }
    }
    
    /**
     * 
     * @param obj Elemento a agregar.
     * @return
     */
    
    public E push(E obj) {
       Nodo <E> nodoNuevo = new Nodo(obj,tope);
        this.tope = nodoNuevo;
        return null;
    }

    /**
     * 
     * @return
     */
    
    public E peek() {
    	if(isEmpty()) {
    		throw new UnsupportedOperationException("Not supported yet.");
    	}else {
    		return tope.datos;
    	}
    }

    
    /**
     * Regresa que esta en el tope de la pila y lo elimina.
     * @return Regresa al elemento que esta en el tope de la pila y lo elimina. 
     */
    
    public E pop() {
    	if(isEmpty()) {
    		throw new UnsupportedOperationException("Not supported yet.");
    	}else {
    		E res = tope.datos;
    		tope = tope.sig;
    		return res;
    	}
    }
    
    /**
     * Vacia toda lista.
     * @return Regresa null si esta vacia
     */

    public boolean isEmpty() {
        return tope == null;
    }

}
