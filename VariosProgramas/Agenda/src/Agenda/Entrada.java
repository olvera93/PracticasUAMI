package Agenda;

public class Entrada {

	String nombre;
	String telefono;
		
	public Entrada(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Entrada(String nombre) {
		this.nombre = nombre;
	}

	public Entrada() {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Entrada) {
				Entrada E = (Entrada)obj;
				boolean iguales = E.nombre.equals(this.nombre);
				return iguales;
		}else {
			return false;
		}

	}
	
	
}
