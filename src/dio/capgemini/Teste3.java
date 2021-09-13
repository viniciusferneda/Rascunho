package dio.capgemini;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teste3 {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int valores = scr.nextInt();
        Map<Integer, Integer> numeros = new HashMap<>();

        //declare as variaveis corretamente e continue a sua solução

        for (int i = 0; i < valores; i++) {
            int numero = scr.nextInt();
            if(numeros.containsKey(numero)) {
                Integer numAux = numeros.get(numero);
                numAux++;
                numeros.put(numero, numAux);
            } else {
                numeros.put(numero, 1);
            }
        }

        numeros.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(num -> System.out.println(num.getKey() + " aparece " + num.getValue() + " vez(es)"));
    }

}
