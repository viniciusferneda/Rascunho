package normalizar.transacoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NormalizarTransacoes {

    private static String dirTransacoes = "C:\\eclipse\\ws_qualirede\\Rascunho\\src\\transacoes.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(dirTransacoes);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        long nLinhas = new BufferedReader(new FileReader(file)).lines().count();
        String line = "";
        for (int i = 0; i < nLinhas; i++) {
            if (i % 10 == 0) {
                line += "\n";
            }
            line += fileReader.readLine();
        }
        System.out.println(line);
    }

}
