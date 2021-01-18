package donus;

public class Teste3 {

    public static int ArrayChallenge(int[] arr) {
        Integer[] arraySemRepetidos = new Integer[arr.length];
        int qtdEntradaRepetidas = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isContain = false;
            for (int j = 0; j < arraySemRepetidos.length; j++) {
                if(arraySemRepetidos[j] != null && arraySemRepetidos[j] == arr[i]){
                    isContain = true;
                    qtdEntradaRepetidas++;
                }
            }
            if(!isContain){
                arraySemRepetidos[i] = arr[i];
            }
        }
        /*for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                if (arr[i] == arr[i - 1]) {
                    qtdEntradaRepetidas++;
                }
            }
        }*/
        return qtdEntradaRepetidas;
    }

    public static void main(String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.println(ArrayChallenge(new int[]{0, -2, -2, 5, 5, 5}));
        System.out.println(ArrayChallenge(new int[]{0, 2, 2, 2, 5}));
        System.out.println(ArrayChallenge(new int[]{0, 2, 5}));
    }

}
