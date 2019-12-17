package validate.size.number;

import java.util.regex.Pattern;

public class ValidateSizeNumber {

    final static String DOUBLE_PATTERN = "[0-9]{1,18}(\\\\.[0-9]*)?";

    public static void main(String[] args) {
        double vlRendaMensal = 999999999999999999.99d;
        String vlRendaMensalStr = String.valueOf(vlRendaMensal);
        System.out.println(Pattern.matches(DOUBLE_PATTERN, vlRendaMensalStr));
    }

}
