package practica7;

public class Ordenacion {

	static int posMin;
	int pos;
	
	//Seleccion DIRECTA
	public void seleccionDirecta(Comparable [] tabla) {
		for(pos= 0 ; pos < tabla.length-1 ; pos++) {
			posMin = seleccion(tabla,pos);
			swap(tabla, pos , posMin);
		}
	}
	
	private static int seleccion (Comparable [] tabla , int pos) {
		posMin = pos;
		for(int j = pos+1 ; j < tabla.length ; j++) {
			if(tabla[j].compareTo(tabla[posMin])  < 0 ) {
				posMin = j;
			}
		}
		return posMin;
	}
	
	private static void swap(Comparable[]tabla,int i, int j) {
		Comparable aux = tabla[i];
		tabla[i] = tabla[j];
		tabla[j] = aux;
		
	}
	
	//INSERCION DIRECTA
	public void insercionDirecta(Comparable[] tabla) {
		for(int i = 1 ; i < tabla.length ; i++) {
			insercion(tabla,i);
		}
	}
	
	private static void insercion(Comparable [] tabla , int pos) {
		Comparable aux = tabla[pos];
		while(pos > 0 && aux.compareTo(tabla[pos-1]) < 0) {
			tabla[pos] = tabla[pos-1];
			pos--;
		}
		tabla[pos]=aux;
	}

	//BURBUJA
	public void burbuja(Comparable[] tabla) {
		for(int i = 0 ; i < tabla.length ; i++) {
			for(int j = tabla.length-1 ; j > i ; j--) {
				if(tabla[j-1].compareTo(tabla[j]) > 0) {
					swap(tabla,j-1,j);
				}
			}
		}
	}
	
	
	//MERGESORT
	public void margeSort(Comparable[] tabla){
	      
        if(tabla.length>1){
            int mitad = tabla.length/2;
            Comparable [] tablaIzq = new Comparable[mitad];
            Comparable[] tablaDer = new Comparable[tabla.length-mitad];
            System.arraycopy(tabla, 0, tablaIzq, 0, mitad);
            System.arraycopy(tabla, mitad, tablaDer, 0, tabla.length-mitad);
                      
            margeSort(tablaIzq);
            margeSort(tablaDer);
            intercalar(tabla,tablaIzq,tablaDer);
        }
    }
    
    private static void intercalar(Comparable[] tabla, Comparable[] tablaIzq, Comparable[] tablaDer){
        int i=0;
        int j=0;
        int k=0;
               
        while(i<tablaIzq.length && j<tablaDer.length){
            if(tablaIzq[i].compareTo(tablaDer[j])<0){
                tabla[k] = tablaIzq[i];
                k++;
                i++;
            }else{
                tabla[k] = tablaDer[j];
                k++;
                j++;
            }
        }
        while(i<tablaIzq.length){
            tabla[k] = tablaIzq[i];
            k++;
            i++;
        }
        while(j<tablaDer.length){
            tabla[k] = tablaDer[j];
            k++;
            j++;
        }
    }
	
	//QUICKSORT
	public void quickSort(Comparable [] tabla) {
		ordenamientoRapido(tabla,0,tabla.length-1);
	}
	
	private static void ordenamientoRapido(Comparable[] tabla , int ini , int fin) {
		int indPiv;
		if(ini < fin) {
			indPiv = particion(tabla,ini,fin);
			ordenamientoRapido(tabla,ini,indPiv-1);
			ordenamientoRapido(tabla,indPiv+1,fin);
		}
	}
	
	
	
	private static int particion(Comparable [] tabla, int ini, int fin) {
		int subir,bajar;
		Comparable pivote = tabla[ini];
		subir = ini;
		bajar = fin;
		do {
			while(subir < fin && pivote.compareTo(tabla[subir]) >= 0) {
				subir++;
			}
			while( pivote.compareTo(tabla[bajar]) < 0) {
				bajar--;
			}
			if(subir < bajar) {
				swap(tabla,subir,bajar); 
			}
		}while(subir < bajar);
		return bajar;
	}

}



