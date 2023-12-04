package cosasdesandra;
public class runable implements Runnable{

	private Thread miHilo = null;
	public runable(String str){
		miHilo = new Thread (this, str);
		miHilo.start();
		
	}
	public void run() {
	for (int i = 0; i<10; i++) {
		System.out.println(i +" " + miHilo.getName());
		try {
			Thread.sleep((long)(Math.random()*1000));
		}catch(Exception e) {
			
		}
	}
		
		
	}	
}


