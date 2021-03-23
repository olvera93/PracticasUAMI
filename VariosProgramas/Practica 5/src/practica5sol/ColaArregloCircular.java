package practica5sol;

public class ColaArregloCircular<E> {
	private int frente;
    private int posterior;
    private int tam;
    private int capacidad;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] datos;
    
    public ColaArregloCircular() {
        this(DEFAULT_CAPACITY);
    }
    
    public ColaArregloCircular(int capacidad) {
        this.capacidad = capacidad;
        datos = (E[]) new Object[capacidad];
        frente = 0;
        posterior = capacidad - 1;
        this.tam = 0;
    }
    
    public boolean offer(E e) {
    	if(tam == capacidad) {
    		reasignacion();
    	}
    	tam ++;
    	posterior = (posterior + 1) % capacidad;
    	datos[posterior] = e;
    	return true;
    }
    
    public E peek() {
    	if(tam == 0) {
    		return null;
    	}else {
    		return datos[frente];
    	}
    }
    
    public E poll() {
    	if(tam == 0) {
    		return null;
    	}
    	E resultado = datos[frente];
    	frente = (frente + 1) % capacidad;
    	return resultado;
    }
    
    private void reasignacion(){
    	int capacidadNueva = 2 * capacidad;
    	E [] datosNuevos = (E []) new Object [capacidadNueva];
    	int j = frente;
    	
    	for(int i = 0 ; i < tam ; i++) {
    		datosNuevos[i] = datos [j];
    		j = (j + 1) % capacidad;
    	}
    	posterior = tam - 1;
    	capacidad = capacidadNueva;
    	datos = datos.clone();
    }

    public int size() {
    	return tam;
    }


}
