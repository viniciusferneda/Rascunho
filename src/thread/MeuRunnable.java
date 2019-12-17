package thread;

public class MeuRunnable implements Runnable {

	public void run() {
		System.out.println("Inicio "+Thread.currentThread().getName() + " MeuRunnable");
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fim "+Thread.currentThread().getName() + " MeuRunnable");
    }
	
}
