package geekhunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyClass {

    private static int tamanhoSenha = 0;

    public static String processInput(String inputLine) {
        String senha = "";
        if (inputLine.length() == 1) {
            tamanhoSenha = Integer.parseInt(inputLine.substring(0));
        } else {
            final List<String> lSenhas = new ArrayList<>();
            for (int i = 0; i < inputLine.length(); i++) {
                if(tamanhoSenha > inputLine.length()){
                    lSenhas.add(inputLine.substring(i, inputLine.length()));
                }else {
                    lSenhas.add(inputLine.substring(i, tamanhoSenha));
                    tamanhoSenha++;
                }
            }
            final Map<String, Integer> mapSenhas = new HashMap<>();
            for (final String sen : lSenhas) {
                if (mapSenhas.containsKey(sen)) {
                    mapSenhas.put(sen, mapSenhas.get(sen) + 1);
                } else {
                    mapSenhas.put(sen, 1);
                }
            }
            int maiorSenha = 0;
            for (String key : mapSenhas.keySet()) {
                if (mapSenhas.get(key) > maiorSenha) {
                    senha = key;
                    maiorSenha = mapSenhas.get(key);
                }
            }
        }
        return senha;
    }

    //Essa função geralmente não precisa ser alterada.
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext() == true) {
            String inputLine = scanner.next();
            System.out.println(processInput(inputLine));
        }
    }

}
