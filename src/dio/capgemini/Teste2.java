package dio.capgemini;

import java.util.Scanner;

public class Teste2 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int cont = 0;
        int n = 1;
        double soma = 0;
        while (n >= 0) {
            n = leitor.nextInt();
            if (n > 0) {
                //complete o codigo
                soma += n;
                cont++;
            }
        }
        double media = soma / cont;
        System.out.println(String.format("%.2f", media));
    }

}
