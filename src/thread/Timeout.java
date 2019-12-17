package thread;

public class Timeout {

	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getName());
		 
        //1 - Thread
        //MinhaThread t = new MinhaThread();
        //t.start();
 
        //2 - Runnable
        //MeuRunnable r = new MeuRunnable();
        //Thread thread = new Thread(r);
        //thread.start();
		try {
			System.out.println("##### Iniciando a aplicação  #####");
	        //Inicia a thread de keep alive para atualizar o arquivo a cada 1 minuto
	        //KeepAliveThread keep = new KeepAliveThread("C:\\temp\\isAlive.alive", 1);
			//KeepAliveThreadInterrupted keep = new KeepAliveThreadInterrupted(1);
			Thread keep = new Thread(){
				@Override
	            public void run() {
	                try {
	                	Thread.sleep(60000);
	                    System.out.println("acabou thread!!");
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        };
	        keep.setDaemon(true);
            keep.start();
            
            while(true) {
                System.out.println("Executando o programa");
                System.out.println(keep.getName()+"-"+keep.isAlive());
                //forca a saída do programa para simular um erro
                if(!keep.isAlive()) {
                    System.out.println("Finalizando o programa");
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
	}
	
}
