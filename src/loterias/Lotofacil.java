package loterias;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotofacil {

    private static final int QTD_NUMEROS_POR_JOGO = 15;
    private static final int NUMERO_MAXIMO_JOGO = 25;
    private static final int QTD_CONCURSOS = 5;

    public static void main(String[] args) {
        numerosRandomicos();
        //numerosMaisSaem();
    }

    private static void numerosMaisSaem() {
        Integer[] numeros = { 39, 52, 49, 53, 4, 44, 10, 15, 40, 31, 38, 18, 16, 79, 5, 26, 29, 73, 70, 72, 19, 42, 28, 56, 61, 43, 9, 45, 37, 55, 64,
                76, 27, 71, 74, 80, 1, 13, 22, 34, 69, 8, 14, 36, 54, 59, 75, 6, 66, 2, 63, 78, 7, 32, 33, 41, 48, 50 };

        List<Integer> lNum = Arrays.asList(numeros);
        Collections.shuffle(lNum);

        HashMap<Integer, List<Integer>> mapNumeros = new HashMap<>();
        int index = 0;
        List<Integer> lNumAux = new ArrayList<>();
        for (int i = 0; i < lNum.size(); i++) {
            lNumAux.add(lNum.get(i));
            if (i <= 24) {
                if ((lNumAux.size()) % 8 == 0) {
                    Collections.sort(lNumAux);
                    mapNumeros.put(index, lNumAux);
                    index++;
                    lNumAux = new ArrayList<>();
                }
            } else if (i > 24 && i <= 48) {
                if ((lNumAux.size()) % 6 == 0) {
                    Collections.sort(lNumAux);
                    mapNumeros.put(index, lNumAux);
                    index++;
                    lNumAux = new ArrayList<>();
                }
            } else if (i > 48) {
                if ((lNumAux.size()) % 5 == 0) {
                    Collections.sort(lNumAux);
                    mapNumeros.put(index, lNumAux);
                    index++;
                    lNumAux = new ArrayList<>();
                }
            }
        }
        for (Integer jogo : mapNumeros.keySet()) {
            System.out.println("***************************");
            for (Integer num : mapNumeros.get(jogo)) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void numerosRandomicos() {
        int max = NUMERO_MAXIMO_JOGO;
        HashMap<Integer, List<Integer>> mapNumeros = new HashMap<>();
        int index = 0;
        Set<Integer> setNumAux = new HashSet<>();
        final int qtdNumeros = QTD_CONCURSOS * QTD_NUMEROS_POR_JOGO;
        for (int i = 0; i < qtdNumeros; i++) {//
            int nextInt = new SecureRandom().nextInt(max) + 1;
            while (setNumAux.contains(nextInt)) {
                nextInt = new SecureRandom().nextInt(max) + 1;
            }
            setNumAux.add(nextInt);
            if ((i + 1) % QTD_NUMEROS_POR_JOGO == 0) {
                List<Integer> lNumeros = new ArrayList<>(setNumAux);
                Collections.sort(lNumeros);
                mapNumeros.put(index, lNumeros);
                index++;
                setNumAux = new HashSet<>();
            }
        }
        for (Integer jogo : mapNumeros.keySet()) {
            System.out.println("*************************** Jogo "+ jogo+1 +" ***************************");
            for (final Integer num : mapNumeros.get(jogo)) {
                if(num < 10){
                    System.out.print("0" + num + " ");
                }else {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }

}
