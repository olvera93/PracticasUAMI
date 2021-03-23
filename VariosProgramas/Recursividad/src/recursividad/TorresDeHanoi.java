package recursividad;

public class TorresDeHanoi {
	public static String mostrarMovimientos(int n, char posteInicio, char posteDestino, char posteTemporal) {
		if(n == 1){
            return "Mover disco 1 del poste "+posteInicio+ " al poste "+ posteDestino +"\n";
        }else{
            return mostrarMovimientos(n-1,posteInicio,posteTemporal,posteDestino)+
                    "Mover disco" + n + " del poste " + posteInicio + " a poste " + posteDestino + "\n" +
                    mostrarMovimientos(n-1,posteTemporal,posteDestino,posteInicio);
        }   
    }
}
