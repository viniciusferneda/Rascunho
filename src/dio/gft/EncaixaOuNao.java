package dio.gft;

import java.util.Scanner;

public class EncaixaOuNao {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();

        for (int i = 0; i < count; i++) {
            String num1 = scan.next();
            String num2 = scan.next();
            if(num1.length() < num2.length()){
                System.out.println("nao encaixa");
            }else{
                if(num1.substring(num1.length()-num2.length()).equals(num2)) {
                    System.out.println("encaixa");
                }else{
                    System.out.println("nao encaixa");
                }
            }
        }

    }

}
