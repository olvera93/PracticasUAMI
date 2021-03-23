package practica5sol;

public class Principal {
	
public static void main(String[] args) {
        
        System.out.println("********PILA********");
        PilaArrayL<Contacto> p = new PilaArrayL<>();
        //PilaLinkedL<Contacto> p = new PilaLinkedL<>();
        
        p.push(new Contacto("Ana","123"));
        p.push(new Contacto("Beto","123"));
        p.push(new Contacto("Carlos","123"));
        
        System.out.println("Tope: " + p.peek().getNombre() + ":" + p.peek().getTelefono());
        p.pop();
        System.out.println("Tope: " + p.peek().getNombre() + ":" + p.peek().getTelefono());
        p.pop();
        System.out.println("Tope: " + p.peek().getNombre() + ":" + p.peek().getTelefono());
        p.pop();
        
        System.out.println("********COLA********");
        ColaListaSimple<Contacto> c = new ColaListaSimple<>();
        //ColaArregloCircular<Contacto> c = new ColaArregloCircular<>();
        
        c.offer(new Contacto("Ana","123"));
        c.offer(new Contacto("Beto","123"));
        c.offer(new Contacto("Carlos","123"));
        
        System.out.println("Tamaño: " + c.size() + ", Turno: " + c.peek().getNombre() + ":" + c.peek().getTelefono());
        c.poll();
        System.out.println("Tamaño: " + c.size() + ", Turno: " + c.peek().getNombre() + ":" + c.peek().getTelefono());
        c.poll();
        System.out.println("Tamaño: " + c.size() + ", Turno: " + c.peek().getNombre() + ":" + c.peek().getTelefono());
        c.poll();
        
        System.out.println("********Identifcador de Palindromos********");
        
        IdentificadorDePalindromos ip = new IdentificadorDePalindromos();
        System.out.println( ip.esPalindromo("Anita lava la tina") );
        System.out.println( ip.esPalindromo("No es palindromo") );
        System.out.println( ip.esPalindromo("Sana tigre vas a correr rocas a ver gitanas") );
        
    }
    


}
