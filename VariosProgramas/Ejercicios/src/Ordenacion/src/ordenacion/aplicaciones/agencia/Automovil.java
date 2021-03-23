package ordenacion.aplicaciones.agencia;

import java.util.Comparator;

public class Automovil implements Comparable<Automovil>{

	private String marca;
	private String modelo;
	private int anio;
	private Motor motor=null;
	public Automovil() {
		super();
	}
	public Automovil(String marca, String modelo, int anio, double cf, int cilindros) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.motor = new Motor(cf,cilindros);
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	@Override
	public String toString() {
		return "\nAutomovil: \n\tmarca=" + marca + "\n\tmodelo=" + modelo + "\n\tanio=" + anio + "\n\tmotor=" + motor ;
	}
	@Override
	public int compareTo(Automovil o) {
		
		 return Comparator.comparing(Automovil::getMarca)
	              .thenComparing(Automovil::getModelo)	    
	              .thenComparingInt(Automovil::getAnio)
	              .thenComparing(Automovil::getMotor)
	              .compare(this, o);
	}
	
}
