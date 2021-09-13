package dio.gft;

import java.io.IOException;
import java.util.Scanner;

public class Multiplos {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        //continue a solucao
        int num1  = leitor.nextInt();
        int num2  = leitor.nextInt();
        if (num1 % num2 == 0 || num2 % num1 == 0 ) {
            System.out.println("Sao Multiplos");
        } else {
            System.out.println("Nao sao Multiplos");
        }
    }

}
