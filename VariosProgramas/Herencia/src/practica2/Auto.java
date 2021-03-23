package practica2;

public class Auto extends Terrestre {

	private String tipo;

	public Auto(String alcance, double precio, int ruedas, String tipo) {
		super(alcance, precio, ruedas);
		this.tipo = tipo;
	}
	
	String informacion() {
		return "\n" + cantidad() + "\n" + "Tipo" + "---> " + tipo; 
	}
	
}
