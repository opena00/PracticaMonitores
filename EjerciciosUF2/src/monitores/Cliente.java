package monitores;

//Clase que representa el cliente (hilo)
public class Cliente extends Thread {

 // Identificador del cliente
 private int id;

 // Referencia al banco (monitor)
 private Banco banco;

 // Constructor del cliente
 public Cliente(int id, Banco banco) {
     // Se asigna el identificador y el banco
     this.id = id;
     this.banco = banco;
 }

 // Método que devuelve el identificador del cliente
 public long getId() {
     return id;
 }

 // Método que se ejecuta al iniciar el hilo
 public void run() {
     // El cliente intenta ingresar al banco
     banco.ingresarBanco(this);
     // El cliente realiza alguna operación en el banco
     // Simulamos un tiempo aleatorio entre 1 y 5 segundos
     try {
         sleep((int) (Math.random() * 5000) + 1000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     // El cliente sale del banco
     banco.salirBanco(this);
 }
}

//Clase principal que crea e inicia los hilos
