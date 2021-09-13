package dio.capgemini;

import java.util.Scanner;

public class Teste1 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
//declare suas variaveis corretamente
        int vlsPares = 0;
        int vlsImpares = 0;
        int vlsPositivos = 0;
        int vlsNegativos = 0;
        int valor;

//continue a solução
        for (int i = 0; i < 5; i++) {
            valor = leitor.nextInt();
            if(valor % 2 == 0){
                vlsPares++;
            }else{
                vlsImpares++;
            }
            if(valor < 0){
                vlsNegativos++;
            }else if (valor > 0){
                vlsPositivos++;
            }
        }
//insira suas variaveis corretamente
        System.out.println(vlsPares + " valor(es) par(es)");
        System.out.println(vlsImpares + " valor(es) impar(es)");
        System.out.println(vlsPositivos + " valor(es) positivo(s)");
        System.out.println(vlsNegativos + " valor(es) negativo(s)");
    }



}
