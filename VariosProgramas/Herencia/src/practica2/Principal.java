package practica2;

public class Principal {
	public static void main(String [] args) {
		
		Bicicleta bici = new Bicicleta("Personal", 45, 2, "BMX");
		Auto au = new Auto("Masivo", 39221, 4, "Familiar");
		
		System.out.println(bici.informacion());
		System.out.println(au.informacion());
		
	}

}
