package recursividad;

public class MetodosRecursivos {
	
	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
	
	public static double potencia(double x , int n) {
		if(n==0){
            return 1;
        }else{
            return x*potencia(x,n-1);
        }
    }
    
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }else{
            if(n==1){
                return 1;
            }else{
                return fibonacci(n-1) + fibonacci(n-2);
            }
        }

	}
	
    private static int busquedaLineal(Object[] items, Object target, int posFirst){
        if(posFirst == items.length){
            return -1;
        }else{
            if(target.equals(items[posFirst])){
                return posFirst;
            }else{
                return busquedaLineal(items,target,posFirst + 1);
            }
        }
        
    }
    
    public static int busquedaLineal(Object[] items, Object target){
        return busquedaLineal(items,target,0);
    }
    
    private static <T> int busquedaBinaria(T[] items, Comparable<T> target, int ini, int fin){
        if(fin<ini){
            return -1;
        }else{
            int medio = (ini + fin)/2;
            int resultado = target.compareTo(items[medio]);
            if(resultado == 0){
                return medio;
            }else{
                if(resultado < 0){
                    return busquedaBinaria(items,target,ini,medio-1);
                }else{
                    return busquedaBinaria(items,target,medio+1,fin);
                }
            }
        }
    }
    
    public static <T> int busquedaBinaria(T[] items, Comparable<T> target){
        return busquedaBinaria(items,target,0,items.length-1);
    }


}
