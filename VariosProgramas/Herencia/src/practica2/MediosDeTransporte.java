package practica2;

public class MediosDeTransporte {
	
	private String alcance;
	private double precio;
	
	public MediosDeTransporte(String alcance, double precio) {
		this.alcance = alcance;
		this.precio = precio;
	}

	public String getAlcance() {
		return alcance;
	}

	public double getPrecio() {
		return precio;
	}

	String getInformacion() {
		return "Alcance" + "---> " + alcance + "\n" + "Precio" + "---> " + precio;
	}
	
	
	
	

	
	

}
