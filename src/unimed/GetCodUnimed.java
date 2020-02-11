package unimed;

public class GetCodUnimed {

    public static void main(String[] args) {
        final String fileName = "NDN____123.027";
        final Integer tpArqParcial = null;
        System.out.println(getCodUnimed(fileName, tpArqParcial));
    }

    private static String getCodUnimed(String fileName, Integer tpArqParcial) {
        String codUnimed;
        final String[] fileNameArray = fileName.split("\\.");
        if (tpArqParcial != null) {
            codUnimed = fileNameArray[0].substring(3, fileNameArray[0].length() - 2);
        } else {
            codUnimed = fileNameArray[0].substring(3);
        }
        codUnimed = codUnimed.replace("_", "");
        return codUnimed;
    }

}
