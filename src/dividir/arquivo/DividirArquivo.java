package dividir.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class DividirArquivo {

    private static long _rowNum = 0;
    private static BufferedReader _fReader;
    private static String dirLog = "C:\\work\\log\\unibr73";

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        System.out.println("Iniciou [main]");
        File f = new File(dirLog + "\\server.log");
        _fReader = new BufferedReader(new FileReader(f));
        long nLinhas = new BufferedReader(new FileReader(f)).lines().count();
        readLines(250000, nLinhas);
    }

    private static void readLines(long lines, long nLinhas) throws IOException {
        System.out.println("Iniciou [readLines]");
        if (nLinhas > lines) {
            int qtdArq = new BigDecimal(nLinhas / lines).setScale(0, BigDecimal.ROUND_UP).intValue();
            for (int i = 0; i < qtdArq; i++) {
                FileWriter arq = new FileWriter(dirLog + "\\server" + i + ".txt");
                PrintWriter gravarArq = new PrintWriter(arq);
                long init = lines - 250000;
                for (long l = init; l < lines; l++) {
                    gravarArq.println(readLine());
                }
                lines = lines + 250000;
                gravarArq.close();
            }
        } else {
            FileWriter arq = new FileWriter(dirLog + "\\server" + 0 + ".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for (long i = 0; i < nLinhas; i++) {
                gravarArq.println(readLine());
            }
            gravarArq.close();
        }
        System.out.println("Terminou [readLines]");
    }

    private static String readLine() throws IOException {
        String line = _fReader.readLine();
        if (line == null) {
            _fReader.close();
            System.out.println("Fim do arquivo! " + _rowNum);
            System.exit(0);
        }
        _rowNum++;
        return line;
    }

}
