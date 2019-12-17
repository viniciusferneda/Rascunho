package thread;

public class KeepAliveThreadInterrupted extends Thread {

	private long timeWaiting;
	
	public KeepAliveThreadInterrupted(int minutesWaiting){
		timeWaiting = 1000 * 60 * minutesWaiting;
		setDaemon(true);
	}
	
	@Override
	public void run() {
		System.out.println("Iniciou keep alive...."+Thread.currentThread().getName());
		try {
			Thread.sleep(timeWaiting);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finalizou keep alive...."+Thread.currentThread().getName());
	}
}
