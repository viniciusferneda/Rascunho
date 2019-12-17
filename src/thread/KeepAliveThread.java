package thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class KeepAliveThread extends Thread {

	private File file;
    private long timeWaiting;
 
    public KeepAliveThread(String completePath, int minutesWaiting) throws IOException {
        //#1
        file = new File(completePath);
 
        if(file.exists()) {
            boolean deletou = file.delete();
            if(!deletou) {
                throw new IOException("Não foi possível deletar o arquivo");
            }
        }
        file.createNewFile();
        //#2
        timeWaiting = 1000 * 60 * minutesWaiting;
        //#3
        setDaemon(true);
    }
 
    @Override
    public void run() {
        //#4
        while(true) {
            FileWriter fw = null;
            try {
                //#5
                fw = new FileWriter(file);
                fw.write(String.valueOf(System.currentTimeMillis()));
                fw.flush();
                fw.close();
                System.out.println("Atualizando keep alive....");
                //#6
                Thread.sleep(timeWaiting);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
