package excepciones.uso;

public class Ejemplo3 {


		public static void main(String argv[]){
			double datos[] = new double[50];
			double mayor;
			int i;
			mayor=datos[0];
			try{
				for(i=1;true;i++){
				      datos[i]=Math.ceil(Math.random()*10);
				      if(mayor < datos[i])
				    	    mayor = datos[i];
				    		 
				}      
			}catch(ArrayIndexOutOfBoundsException e){
			    System.out.println("Arreglo inicializado");	  			
			}
  			try{
  				for(i=0;true;i++)
  					System.out.println(" "+datos[i]);
  					  
  			}catch(ArrayIndexOutOfBoundsException e){
  				
  			    System.out.println("El valor mayor es:"+mayor);	
  			}
			
		}
	}