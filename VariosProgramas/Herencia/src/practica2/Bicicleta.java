package practica2;

public class Bicicleta extends Terrestre {
	
	private String tipo;

	public Bicicleta(String alcance, double precio, int ruedas, String tipo) {
		super(alcance, precio, ruedas);
		this.tipo = tipo;
	}
	
	String informacion() {
		return cantidad() + "\n" + "Tipo" + "---> " + tipo;
	}

}
