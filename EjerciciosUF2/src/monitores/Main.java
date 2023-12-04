package monitores;

public class Main {

	 public static void main(String[] args) {
	     // Se crea el banco (monitor)
	     Banco banco = new Banco();
	     // Se crea un array de 5 clientes (hilos)
	     Cliente[] clientes = new Cliente[5];
	     // Se inicializan los clientes con un identificador y el banco
	     for (int i = 0; i < clientes.length; i++) {
	         clientes[i] = new Cliente(i + 1, banco);
	     }
	     // Se inician los hilos
	     for (int i = 0; i < clientes.length; i++) {
	         clientes[i].start();
	     }
	 }
	}
