package random;

import java.util.Random;

public class RandomExample {

    public static void main(String[] args) {
        int valor = new Random().nextInt(10) + 1;
        System.out.println(valor);
    }
}
