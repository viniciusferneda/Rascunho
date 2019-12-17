package preencher.string;

import com.google.common.base.Strings;

public class PreencherString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final String nrMatricula = "123456789";

        final String nrMatricula9 = String.format("%9s", nrMatricula).replace(' ', '0');
        System.out.println(nrMatricula9);

        final String nrMatricula7 = nrMatricula.substring(nrMatricula.length() - 7);
        System.out.println(nrMatricula7);

        final String nrCartao =
                formatStringWithLpad(String.valueOf(2530).substring(0, 2), 2) + formatStringWithLpad(nrMatricula.substring(nrMatricula.length() - 7), 7)
                        + formatStringWithLpad(String.valueOf(00), 2);

        System.out.println(nrCartao);

        final String nrMatriculaSemDV = nrMatricula.substring(0, nrMatricula.length() - 1);
        System.out.println(nrMatriculaSemDV);
    }

    private static String formatStringWithLpad(String str, int size) {
        return str == null ? "" : Strings.padStart(str, size, '0');
    }
}
