package practica7;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contacto[] contactos = new Contacto[10];

		 contactos[0] = new Contacto("Carla","3");
		 contactos[1] = new Contacto("Pedro","17");
		 contactos[2] = new Contacto("Juan","10");
		 contactos[3] = new Contacto("Ana","1");
		 contactos[4] = new Contacto("Beto","2");
		 contactos[5] = new Contacto("Beto","22");
		 contactos[6] = new Contacto("Gabriel","7");
		 contactos[7] = new Contacto("Elena","5");
		 contactos[8] = new Contacto("Nicolas","14");
		 contactos[9] = new Contacto("Ana","11");

		 for(Contacto c: contactos){
		 System.out.print( c.getNombre() + ":" + c.getTelefono()+ ", ");
		 }
		 System.out.println();

		 Ordenacion o = new Ordenacion();
		 
		// o.seleccionDirecta(contactos);
		 //o.insercionDirecta(contactos);
		 //o.burbuja(contactos);
		 //o.quickSort(contactos);
		 o.margeSort(contactos);
		 System.out.println("\n\nORDENACION :");
		 for(Contacto c: contactos){
			 System.out.print( c.getNombre() + ":" + c.getTelefono()+ ", ");
			 }
		 System.out.println();
		 
		 
		/* o.mergeSort(contactos);
		 System.out.println("\nORDENACION MERGESORT:");
		 for(Contacto c: contactos){
			 System.out.print( c.getNombre() + ":" + c.getTelefono()+ ", ");
			 }*/
		 
		
		 
		
	}

}
