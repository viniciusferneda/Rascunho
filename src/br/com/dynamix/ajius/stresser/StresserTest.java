package br.com.dynamix.ajius.stresser;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

public class StresserTest {

    //@Test
    public void stressTest() {
        final Queue<Thread> waitqueue = new LinkedList<Thread>();

        for (int k = 0; k < 100; k++) {
            Thread t = new AuxThread(k);
            waitqueue.add(t);
            t.start();
        }

        int count = waitqueue.size();
        while (count > 0) {
            Queue<Thread> q = new LinkedList<Thread>(waitqueue);
            for (Thread t : q) {
                if (!t.isAlive()) {
                    waitqueue.remove(t);
                }
            }
            count = waitqueue.size();
        }

    }

    private static final class AuxThread extends Thread {

        private final int id;

        public AuxThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                URL url = new URL("http://ajius.dynamix.com.br/ajius/fatura/emAnaliseCamaraAction.do");
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();

                byte[] b = new byte[1024];
                StringBuilder sb = new StringBuilder();
                int c = 0;
                while (c != -1) {
                    c = in.read(b);
                    sb.append(new String(b));
                }
                System.out.println("Acabou o item: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
