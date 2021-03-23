package practica2;

public class Terrestre extends MediosDeTransporte {
	
	private int ruedas;

	public Terrestre(String alcance, double precio, int ruedas) {
		super(alcance, precio);
		this.ruedas = ruedas;
	}
	
	String cantidad() {
		return getInformacion() + "\n" + "Llantas" + "---> " + ruedas; 
	}
	
}
