package practica5sol;

import java.util.ArrayList;

public class PilaArrayL<E> {
	
	private ArrayList<E> datos;
    
    public PilaArrayL(){
        datos = new ArrayList<>();
    }

    public E push(E obj) {
        datos.add(obj);
        return obj;
    }

    public E peek() {
    	if(isEmpty()) {
    		throw new UnsupportedOperationException("Not supported yet.");
    	}
    	return datos.get(datos.size()-1);
    }

    public E pop() {
    	if(isEmpty()) {
    		throw new UnsupportedOperationException("Not supported yet.");
    	}
    	return datos.remove(datos.size()-1);
    }

    public boolean isEmpty() {
        return datos.isEmpty();
    }


}
