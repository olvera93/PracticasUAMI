package practica4sol;

import java.util.Arrays;

public class ApalooArrayList<E> {
	
	private static final int CAPACIDAD_INICIAL = 10;
    private E[] datos;
    private int tam = 0;
    private int capacidad = 0;
    
    public ApalooArrayList(){
        capacidad = CAPACIDAD_INICIAL;
        datos = (E[]) new Object[capacidad];
    }
    
    public boolean add(E entrada){
    	if(tam == capacidad) {
    		reasignar();
    	}
    	datos[tam] = entrada;
    	tam ++;
    	return true;
    }
    
    public void add(int indice, E entrada){
        if(indice < 0 || indice > tam) {
        	System.out.println("Error : No such Element Exception");
        }
        if(tam == capacidad) {
        	reasignar();
        }
        
        for(int i = 0 ; i > indice ; i--) {
        	datos[i] = datos[i-1];
        }
        datos[indice] = entrada;
        tam++;
    }
    
    public E get(int indice){
    	if(indice < 0 || indice > tam) {
    		System.out.println("ArrayIndexOutOfBoundException");
    	}
    	return datos[indice];
    }
    
    public E set(int indice, E entrada){
    	if(indice < 0 || indice >= tam) {
    		System.out.println("ArrayIndexOutOfBoundException");
    	}
    	E anterior = datos[indice];
    	datos [indice] = entrada;
    	return anterior;
    }
    
    public E remove(int indice){
    	if(indice < 0 || indice >= tam) {
    		System.out.println("ArrayIndexOutOfBoundException");
    	}
    	E anterior = datos[indice];
    	for(int i = indice + 1 ; i < tam ; i++) {
    		datos [i-1] = datos [i];
    	}
    	tam--;
    	return anterior;
    }
    
    public int size(){
        return tam;
    }
    
    public int indexOf(E elemento){
    	for(int i = 0 ; i < tam ; i++) {
    		if(datos[i].equals(elemento)) {
    			return i;
    		}
    	}
    	return -1;
    }

    private void reasignar() {
        capacidad = 2*capacidad;
        datos = Arrays.copyOf(datos, capacidad);
    }


}
