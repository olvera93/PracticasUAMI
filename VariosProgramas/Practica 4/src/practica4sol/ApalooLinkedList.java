package practica4sol;


/**
 * Clase para una lista simplemente ligada. NO implementa
 * la interfaz List de Java.
 * @param <E> Tipo de elementos a almacenar
 */

public class ApalooLinkedList<E> {
	/** Referencia al primer nodo de la lista */
    private Nodo<E> head = null;
    /** Numero de elementos en la lista */
    private int tam = 0;
    
    /**
     * Un nodo es un contenedor de un elemento de la lista ligada y 
     * una referencia o link al nodo siguiente
     * @param <E> Es el tipo de elemento que almacena la lista
     */
    private static class Nodo<E> {
        private E elemento;
        private Nodo<E> nodoSig;
        
        //Constructores
        private Nodo(E elemento){
            this.elemento = elemento;
            this.nodoSig = null;
        }
        
        private Nodo(E elemento, Nodo<E> nodoSig){
            this.elemento = elemento;
            this.nodoSig = nodoSig;
        }
    }
    
    /**
     * Agrega un elemento al frente de la lista
     * @param elemento El elemento a agregar
     */
    public void addFirst(E elemento){
    	head = new Nodo <> (elemento , head);
    	tam++;
    }
    
    /**
     * Inserta un nodo enseguida de un nodo dado (metodo auxiliar)
     * @param nodo Referencia al nodo base
     * @param elemento El elemento a insertar
     */
    private void addAfter(Nodo<E> nodo, E elemento){
        nodo.nodoSig = new Nodo<> (elemento, nodo.nodoSig);
    	tam++;
    }
    
    /**
     * Elimina el nodo siguiente al nodo dado
     * @param nodo Referencia al nodo base
     * @return El elemento eliminado, null si no hay nodo.
     */
    private E removeAfter(Nodo<E> nodo){
    	Nodo<E> temp = nodo.nodoSig;
    	if(temp != null) {
    		nodo.nodoSig = temp.nodoSig;
    		tam--;
    		return temp.elemento;
    	}else {
    		return null;
    	}
    	
    }

    /**
     * Elimina el primer nodo de la lista
     * @return El nodo removido o null si era vacio
     */
    private E removeFirst(){
    	Nodo<E> temp = head;
    	if(head != null) {
    		head = head.nodoSig;
    	}
    	
    	if(temp != null) {
    		tam--;
    		return temp.elemento;
    	}else {
    		return null;
    	}
    }

    /**
     * Obtiene una referencia al nodo en el indice dado
     * @param indice Posicion del nodo
     * @return Una referencia al nodo o null si no existe
     */
    private Nodo<E> getNodo(int indice){
        Nodo <E> nodo = head;
        for(int i = 0 ; i < indice ; i++) {
        	nodo = nodo.nodoSig;
        }
        return nodo;
    }
    
    /**
     * Obtiene el elemento en la posicion del indice dado
     * @param indice La posicion del elemento que se quiere recuperar
     * @return Elemento en el indice dado
     */
    public E get(int indice){
    	if(indice < 0 || indice >= tam) {
    		System.out.println("Fuera de rango");
    	}
    	Nodo <E> nodo = getNodo(indice);
    	return nodo.elemento;
    	
    }
    
    /**
     * Almacena un elemento en la posicion del indice dado
     * @param indice La posicion donde se almacenara¡
     * @param elemNuevo Elemento a almacenar
     * @return El elemento que estaba en esa posicion.
     */
    public E set(int indice, E elemNuevo){
        if(indice < 0 || indice >= tam) {
        	System.out.println("Fuera de rango");
        }
    	Nodo <E> nodo = getNodo(indice);
    	E resultado = nodo.elemento;
    	nodo.elemento = elemNuevo;
    	return resultado;
    	
    }
    
    /**
     * Inserta un elemento nuevo en el indice dado
     * @param indice La posicion donde se insertara¡
     * @param elemNuevo El elemento a ser insertado
     */
    public void add(int indice,E elemNuevo){
        if(indice < 0 || indice > tam) {
        	System.out.println("Fuera de rango");
        }
        
        if(indice == 0) {
        	addFirst(elemNuevo);
        }else {
        	Nodo <E> nodo = getNodo(indice -1);
        	addAfter(nodo,elemNuevo);
        }
    }
    
    /**
     * Agrega un elemento nuevo al final de la lista
     * @param elemNuevo El elemento a agregar.
     * @return Verdadero siempre.
     */
    public boolean add(E elemNuevo){
    	add(tam,elemNuevo);
    	return true;
    }
    
    /**
     * Obtiene el numero de elementos de la lista
     * @return El numero de elementos en la lista
     */
    public int size(){
    	return tam;
    }
    
    /**
     * Busca el elemento dado y regresa el indice de la primera aparicion
     * o -1 si no esta.
     * @param elemento Elemento a buscar
     * @return El indice de la primera aparicion o -1 si no esta¡
     */
    public int indexOf(E elemento){
    	for(int i = 0 ; i < tam ; i++) {
    		if(get(i).equals(elemento)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    /**
     * Elimina el elemento en el indice dado
     * @param indice Posicion del elemento a eliminar
     * @return El elemento eliminado.
     */
    public E remove(int indice){
    	if(indice < 0 || indice > tam) {
         	System.out.println("Fuera de rango");
        }
    	
    	if(indice == 0) {
    		Nodo <E> nodo = null;
    		E res = removeFirst();
    		return res;
    	}else {
    		Nodo <E> nodo = getNodo(indice-1);
    		E res = nodo.elemento;
    		removeAfter(nodo);
    		return res;
    	}
    	
    }
    
     	
    
    /**
     * Elimina la primera aparicion del elemento dado
     * @param elemento Elemento a eliminar
     * @return true si el elemento se encontro y elimino; false en otro caso.
     */
    
    public boolean remove(E elemento){
    	int indice = indexOf(elemento);
    	if(indice == -1) {
    		return false;
    	}else {
    		remove(indice);
    		return true;
    	}
    	
    }


}
