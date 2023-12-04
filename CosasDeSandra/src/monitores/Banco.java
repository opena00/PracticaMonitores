package monitores;

//Clase que representa el banco (monitor)
public class Banco {

 // Número máximo de clientes que pueden acceder al banco simultáneamente
 private static final int MAX_CLIENTES = 2;

 // Número actual de clientes en el banco
 private int numClientes;

 // Constructor del banco
 public Banco() {
     // Inicialmente no hay ningún cliente en el banco
     numClientes = 0;
 }

 // Método sincronizado para controlar el acceso al banco
 public synchronized void ingresarBanco(Cliente cliente) {
     // Si el número de clientes ha alcanzado el máximo
     if (numClientes == MAX_CLIENTES) {
         // El cliente tiene que esperar a que haya un hueco
         System.out.println("El cliente " + cliente.getId() + " está esperando a ingresar al banco");
         try {
             // El cliente espera a que se le notifique
             wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     // Si hay un hueco, el cliente puede acceder al banco
     System.out.println("El cliente " + cliente.getId() + " ha ingresado al banco");
     // Se incrementa el número de clientes en el banco
     numClientes++;
 }

 // Método sincronizado para controlar la salida del banco
 public synchronized void salirBanco(Cliente cliente) {
     // El cliente sale del banco
     System.out.println("El cliente " + cliente.getId() + " ha salido del banco");
     // Se decrementa el número de clientes en el banco
     numClientes--;
     // Se notifica a los demás clientes que hay un hueco
     	
 }
}