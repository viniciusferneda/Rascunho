package inserir.commit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InserirCommit {

    private static String dirBatata = "C:\\eclipse\\ws_qualirede\\Rascunho\\src\\batata.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(dirBatata);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        long nLinhas = new BufferedReader(new FileReader(file)).lines().count();
        String line = "";
        for (int i = 0; i < nLinhas; i++) {
            line += "\n";
            if (i % 100 == 0) {
                line += "COMMIT;";
                line += "\n";
            }
            line += fileReader.readLine();
        }
        System.out.println(line);
    }
}
