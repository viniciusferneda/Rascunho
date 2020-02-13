package unimed;

public class SplitNomeArquivoA560 {

    private static final String PATTERN = "NDN_fffffff.uuu";
    private static final String PATTERN_TP_ARQ_PARCIAL = "NDN_fffffff_T.uuu";

    private static final String FILE = "ND1_1234567.028";
    //private static final String FILE = "ND1_1234567_1.028";

    public static void main(String[] args) {
        String prefixo = FILE.substring(0, 2);
        String tipoArquivo = FILE.substring(2, 3);
        String documento1 = FILE.substring(4, 11);
        String codUnimed = FILE.substring(12, 15);
        System.out.println(prefixo + " " + tipoArquivo + " " + documento1 + " " + codUnimed);
        //String tpArquivoParcial = FILE.substring(12, 13);
        //String codUnimed = FILE.substring(14, 17);
        //System.out.println(prefixo + " " + tipoArquivo + " " + documento1 + " " + tpArquivoParcial + " " + codUnimed);
    }
}
