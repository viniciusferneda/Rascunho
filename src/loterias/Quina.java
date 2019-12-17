package loterias;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quina {

    public static void main(String[] args) {
        //numerosRandomicos();
        numerosMaisSaem();
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
        int max = 81;
        Set<Integer> numeros = new HashSet<>();
        for (int i = 0; i < 24; i++) {
            int random = new SecureRandom().nextInt(max);
            if (numeros.contains(random)) {
                while (numeros.contains(random)) {
                    random = new SecureRandom().nextInt(max);
                }
            }
            numeros.add(random);
        }
        List<Integer> lNum = new ArrayList<>(numeros);
        HashMap<Integer, List<Integer>> mapNumeros = new HashMap<>();
        int index = 0;
        List<Integer> lNumAux = new ArrayList<>();
        for (int i = 0; i < lNum.size(); i++) {
            lNumAux.add(lNum.get(i));
            if ((i + 1) % 8 == 0) {
                Collections.sort(lNumAux);
                mapNumeros.put(index, lNumAux);
                index++;
                lNumAux = new ArrayList<>();
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

}
