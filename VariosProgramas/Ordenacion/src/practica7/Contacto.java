package practica7;


public class Contacto implements Comparable<Contacto>  {
	private String nombre;
    private String telefono;

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = "0";
    }
    
    public Contacto(String nombre, String telefono) {
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
    public boolean equals(Object obj){
        if(obj instanceof Contacto){
            Contacto e = (Contacto)obj;
            boolean iguales = this.nombre.equals(e.nombre); 
            return iguales;
        }else{
            return false;
        }
    }
    
    @Override
    public int compareTo(Contacto e) {
        return this.nombre.compareTo(e.nombre);
    }

}
