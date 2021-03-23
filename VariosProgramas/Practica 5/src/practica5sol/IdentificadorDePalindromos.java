package practica5sol;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IdentificadorDePalindromos {
	Deque <Character> pila = new ArrayDeque<>();
	Queue <Character> cola = new LinkedList<>();
	
    public boolean esPalindromo(String frase){
    	frase = frase.replace(" ", "").toLowerCase();
    	pila.clear();
    	cola.clear();
    	
    	for(int i = 0 ; i < frase.length() ; i++) {
    		pila.push(frase.charAt(i));
    		cola.offer(frase.charAt(i));
    	}
    	System.out.println("\n"+pila +"\n"+ cola);
    	while(!(pila.isEmpty() && cola.isEmpty())) {
    		if(pila.pop() != cola.poll()) {
    			return false;
    		}
    	}    	
    	return true;
    }
    
    
}
