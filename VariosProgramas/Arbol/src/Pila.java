

import java.util.ArrayList;



	public class Pila {
		
		private ArrayList<Character> cad = new ArrayList<Character>();
		//static ArrayList<NodoAR> ar = new ArrayList<NodoAR>();
		char dato;
		
		Pila(){ }
		void push(char dat) {
			cad.add(dat);
		}
		
		char pop() {
			if(isEmpty()) {
	    		throw new UnsupportedOperationException("Not supported yet.");
	    	}
	    	return cad.remove(cad.size()-1);
	    }

	    public boolean isEmpty() {
	        return cad.isEmpty();
	    }
	    
	    public char peek() {
	    	if(isEmpty()) {
	    		throw new UnsupportedOperationException("Not supported yet.");
	    	}
	    	return cad.get(cad.size()-1);
	    }

	    static String infija_Posfija(String infija) {
	    	String pos = "";
	    	Pila p = new Pila();
	    	char letra;
	    	for (int i = 0; i < infija.length(); i++) {
				letra = infija.charAt(i);
				if(esOperador(letra)) {
					if(letra==')') {
						while(p.peek()!='(')
							pos += p.pop();
						if(p.peek()=='(')
							p.pop();
					}
					if(p.isEmpty()) {
						if(letra!=')')
							p.push(letra);
					}else {
						if(letra!=')') {
							int pe = prioridadExp(letra);
							int pp = priridadPila(p.peek());
							if(pe>pp) {
								p.push(letra);
							}else {
								pos += p.pop();
								p.push(letra);
							}
						}
					}
			    }else 
			    	pos += letra;
	    		}
	    		while(!p.isEmpty()) {
	    			pos += p.pop();
		        }
	    	return pos;
	    }
		private static int priridadPila(char x) {
			if(x=='^')
				return 3;
			if(x=='*' || x=='/')
				return 2;
			if(x=='+' || x=='-')
				return 1;
			if(x=='(')
				return 0;
			if(x==')')
				return 0;
			return 0;
		}
		private static int prioridadExp(char x) {
			if(x=='^')
				return 4;
			if(x=='*' || x=='/')
				return 2;
			if(x=='+' || x=='-')
				return 1;
			if(x=='(')
				return 5;
			if(x==')')
				return 5;
			return 0;
		}
		private static boolean esOperador(char letra) {
			if((letra=='*') || (letra=='/') || (letra=='+') || (letra=='-') || (letra=='^') || (letra=='(') || (letra==')')) {
				return true;
			}else 
			return false;
		}
		
		private static boolean esOperador2(char letra) {
			if((letra=='*') || (letra=='/') || (letra=='+') || (letra=='-') || (letra=='^') ) {
				return true;
			}else 
			return false;
		}
        public static NodoAR arbolExpresion (String cadena) {
        	char caracter;
        	ArrayList<NodoAR> aux = new ArrayList<NodoAR>();
        	for (int i = 0; i < cadena.length(); i++) {
    			caracter =  cadena.charAt(i);
    			if(esOperador2(caracter)) {
    				NodoAR a = aux.remove(aux.size()-1);
    				NodoAR b = aux.remove(aux.size()-1);
    				NodoAR c = new NodoAR(caracter,b,a);
    				aux.add(c);
    			}else {
    				aux.add(new NodoAR(caracter,null,null));
    			}
          }
        	return aux.remove(0);
        }
        
	}
	    
		
