package thread;

public class MinhaThread extends Thread{

	public void run() {
		System.out.println("Inicio "+Thread.currentThread().getName() + " MinhaThread");
		try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fim "+Thread.currentThread().getName() + " MinhaThread");
    }
	
}
