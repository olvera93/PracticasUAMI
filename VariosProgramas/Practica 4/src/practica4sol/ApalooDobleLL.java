package practica4sol;

import java.util.ListIterator;

public class ApalooDobleLL<E> {
	
	 	private Nodo<E> ini = null;
	    private Nodo<E> fin = null;
	    private int tam = 0;
	    
	    public void add(int indice, E elem){
	    	listIterator(indice).add(elem);
	    }
	    
	    public E get(int indice){
	        return listIterator(indice).next();
	    }
	    
	    private ApaloListIter listIterator(int indice) {
	        ApaloListIter iter = new ApaloListIter(indice);
	        return iter;
	    }
	    
	    private static class Nodo<E>{
	        private E elem;
	        private Nodo<E> sig = null;
	        private Nodo<E> ant = null;
	        
	        private Nodo(E elem){
	            this.elem = elem;
	        }
	    }
	    
	    private class ApaloListIter implements ListIterator<E> {
	        private Nodo<E> nextItem;
	        private Nodo<E> lastItemReturned;
	        private int index = 0;
	        
	        public ApaloListIter(int i){
	            if( i<0 || i>tam ){
	                System.out.println("Error: Index Out Of Bounds Exception");
	            }
	            lastItemReturned = null;
	            if(i==tam){
	                index = tam;
	                nextItem = null;
	            }else{
	                nextItem = ini;
	                for(index = 0; index<i;index++){
	                    nextItem = nextItem.sig;
	                }
	            }
	        }
	        
	        @Override
	        public boolean hasNext(){
	        	return (nextItem != null);
	        }
	        
	        @Override
	        public E next(){
	        	if(!hasNext()) {
	        		System.out.println("Error : No such Element Exception");
	        		return null;
	        	}
	        	lastItemReturned = nextItem;
	        	nextItem = nextItem.sig;
	        	index ++;
	        	return lastItemReturned.elem;
	        }
	        
	        @Override
	        public boolean hasPrevious(){
	            throw new UnsupportedOperationException("Not supported yet.");
	        }
	        
	        @Override
	        public E previous(){
	            throw new UnsupportedOperationException("Not supported yet.");
	        }
	        
	        @Override
	        public void add(E elem){
	            Nodo<E> nodoNuevo = new Nodo<>(elem);
	            
	            if(ini==null){//En una lista vacía
	               ini = nodoNuevo;
	               fin = ini;
	            }else if(nextItem == ini){//Al inicio
	            	nodoNuevo.sig = nextItem;
	 	            nextItem.ant = nodoNuevo;
	 	            ini = nodoNuevo;
	            }else if(nextItem == null){//Al final
	                fin.sig = nodoNuevo;
	                nodoNuevo.ant = fin;
	                fin = nodoNuevo;
	            }else{//En medio
	            	nodoNuevo.ant = nextItem.ant;
	            	nodoNuevo.sig = nextItem;
	            	nextItem.ant = nodoNuevo;
	            	nodoNuevo.ant.sig = nodoNuevo;
	            }
	            
	            tam++;
	            index++;
	            lastItemReturned = null;
	        }

	        @Override
	        public int nextIndex() {
	            throw new UnsupportedOperationException("Not supported yet.");
	        }

	        @Override
	        public int previousIndex() {
	            throw new UnsupportedOperationException("Not supported yet."); 
	        }

	        @Override
	        public void remove() {
	        	
	        }

	        @Override
	        public void set(E e) {
	            throw new UnsupportedOperationException("Not supported yet.");
	        }
	    }


}
