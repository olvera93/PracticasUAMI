package practica4sol;

import java.util.Iterator;
import java.util.LinkedList;

import java.util.*;

public class ListaOrdenada <E extends Comparable<E>> implements Iterable<E> {
	private LinkedList<E> ll = new LinkedList<>();

	public void add(E elem){
		int i = 0;
		if(ll.isEmpty()) {
			ll.add(elem);
		}else {
			for(i = 0 ; i < ll.size() ; i++) {
				if(elem.compareTo(ll.get(i)) <= 0) {
					ll.add(i,elem);
					break;
				}
			}
		}
		if(i == ll.size()) {
			ll.add(elem);
		}
		
    }
	
	public void addIter(E elem1) {
    	Iterator<E> elem = ll.iterator();
    	int i = 0;
    	while(elem.hasNext()) {
    		if(elem.next().compareTo(elem1) > 0) {
    			ll.add(i, elem1);
    			break;
    		}
    		i++;
    	}
    	ll.add(elem1);
    }
    
    public E get(int index){
    	return ll.get(index);
    }
    
    @Override
    public Iterator<E> iterator(){
        return ll.iterator();
    }


}
