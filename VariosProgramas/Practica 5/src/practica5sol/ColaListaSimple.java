package practica5sol;

public class ColaListaSimple<E> {
	
	private Nodo<E> frente;
    private Nodo<E> posterior;
    private int tam;
    
    private static class Nodo<E>{
        private E elem;
        private Nodo<E> sig = null;
        
        private Nodo(E elem){
            this.elem = elem;
        }
    }

    public boolean offer(E item) {
        if(frente == null) {
        	posterior = new Nodo <>(item);
        	frente = posterior;
        }else {
        	posterior.sig = new Nodo <>(item);
        	posterior = posterior.sig;
        }
		return false;
    }

    public E poll() {
    	E item = peek();
    	if(item == null) {
    		return null;
    	}
    	frente = frente.sig;
    	tam--;
    	return item;
    }
    
    public E peek() {
    	if(frente == null) {
    		return null;
    	}
    	return frente.elem;
    }
    
    public int size() {
    	return tam;
    }


}
