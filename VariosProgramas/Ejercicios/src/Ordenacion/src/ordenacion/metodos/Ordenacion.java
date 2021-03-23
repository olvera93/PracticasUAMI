package ordenacion.metodos;


public class Ordenacion {

	
/*
 * SE REVISA CADA ELEMENTO DEL ARREGLO QUE SE VA ORDENAR CON EL SIGUIENTE, 
 * INTERCAMBIANDOLOS DE POSICION SI ESTAN EN EL ORDEN EQUIVOCADO.
 * */
	public static <E extends Comparable<E>> void burbuja(E[] datos) {
		
		int i,j;
		E aux;
		for(i=(datos.length-1);i>=0;i--) {
			
			for(j=0;j<i;j++) {
				
				if(datos[j].compareTo(datos[j+1])>0) {
					aux=datos[j];
					datos[j]=datos[j+1];
					datos[j+1]=aux;
				}
				
			}	
		}
	}
	
	public static <E extends Comparable<E>> void burbujaMejorado(E[] datos) {
		
		int i,j;
		E aux;
		boolean f=true;
		for(i=(datos.length-1);i>=0 && f;i--) {
			f=false;
			for(j=0;j<i;j++) {
				
				if(datos[j].compareTo(datos[j+1])>0) {
					f=true;
					aux=datos[j];
					datos[j]=datos[j+1];
					datos[j+1]=aux;
				}
				
			}
			
		}
	}
	/*
	 * BUSCO AL MAYOR Y LO PONGO EN AL FINAL, BUSCO AL SIGUIENTE MAYOR
	 * Y LO PONGO ANTES DEL MAYOR Y ASI SUCESIVAMENTE
	 * */
	public static <E extends Comparable<E>> void seleccion(E[] datos) {
		
		int i,j,imax;
		E omax,aux;
		for(i=datos.length;i>0;i--) {
			omax=datos[0];
			imax=0;
			for(j=0;j<i;j++) {
				if(omax.compareTo(datos[j])<0) {
					omax=datos[j];
					imax=j;		
				}
			}
			aux=datos[i-1];
			datos[i-1]=omax;
			datos[imax]=aux;
		}
	}
	
	
	/*
	 * INSERTO SOBRE UN ARREGLO YA ORDENADO
	 * */
	public static <E extends Comparable<E>> void insercion(E[] datos) {
		
		int i,k;
		E aux;
		boolean f=true;
		for(i=1;i<datos.length;i++) {
			k=i;
			f=true;
			while(k>0 & f) {
				if(datos[k].compareTo(datos[k-1])<0) {
					aux=datos[k];
					datos[k]=datos[k-1];
					datos[k-1]=aux;
					
				}else
					f=false;
				k--;
			}
		}
	}
	
	
	
	public static <E extends Comparable<E>>  void mergesort(E[] datos){

		mergesortRecursivo(datos,0,datos.length);		

	}
	private static <E extends Comparable<E>>  void mergesortRecursivo(E[] datos, int inicio,int fin){
		int medio;
		if(fin!=(inicio+1)){
			medio = (inicio + fin) /2;
			mergesortRecursivo(datos,inicio,medio);
			mergesortRecursivo(datos,medio,fin);
			mezcla(inicio,medio,fin,datos);
		}
	}

	@SuppressWarnings("unchecked")
	private static <E extends Comparable<E>>  void mezcla(int inicio,int medio,int fin,E[] datos)
	{
		int i,j=inicio,k=medio,z=0;
		int tam = (fin - inicio);
		Object[] aux = new Object[tam];
		while(j<medio && k<fin){
			if(datos[j].compareTo(datos[k])<0){ 

				aux[z]=datos[j];
				j++;

			}else{ 
				aux[z]=datos[k];
				k++;
			}
			z++;
		}
		while(j<medio){ 
			aux[z]=datos[j];
			z++;
			j++;
		}
		while(k<fin){ 
			aux[z]=datos[k];
			k++;
			z++;
		}
		for(i=0; i<tam; i++,inicio++) 
			datos[inicio]=(E) aux[i];
	}
	
	
	
}
