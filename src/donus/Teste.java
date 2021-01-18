package donus;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

    public static String StringChallenge(String num) {
        String timeFormmater;
        int number = Integer.valueOf(num);
        if(number < 60){
            timeFormmater = "0:" + num;
        }else{
            int hour = number / 60;
            int minutes = number % 60;
            timeFormmater = hour + ":" + minutes;
        }
        return timeFormmater;
    }
}
