package dio.gft;

import java.util.Scanner;

public class TempoJogo {

    public static void main(String[] args){

        //complete os espaços em branco com sua solução para o problema

        Scanner scan = new Scanner(System.in);
        int inicio, fim, horas;
        inicio = scan.nextInt();
        fim = scan.nextInt();

        if(inicio == fim){
            horas = 0;
        }else if(inicio < fim){
            horas = fim - inicio;
        }else{
            horas = (24 - inicio) + fim;
        }

        if(horas == 0){
            System.out.print("O JOGO DUROU 24 HORA(S)\n");
        }else{
            System.out.print("O JOGO DUROU " + horas + " HORA(S)\n");
        }
    }

}
