package donus;

import java.util.*;

public class Teste3 {

    public static int ArrayChallenge(int[] arr) {
        int qtdEntradaRepetidas = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i != j){
                    if(arr[i] == arr[j]){
                        qtdEntradaRepetidas++;
                    }
                }
            }
        }
        return qtdEntradaRepetidas;
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(ArrayChallenge(new int[] {0,-2,-2,5,5,5}));
    }

}
