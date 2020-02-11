package unimed;

public class GetDocumento1 {

    public static void main(String[] args) {
        final String fileName = "NDN____123.027";
        final Integer tpArqParcial = null;
        System.out.println(getDocumento1(fileName, tpArqParcial));
    }

    private static String getDocumento1(String fileName, Integer tpArqParcial) {
        String documento1;
        final String[] fileNameArray = fileName.split("\\.");
        if (tpArqParcial != null) {
            documento1 = fileNameArray[0].substring(3, fileNameArray[0].length() - 2);
        } else {
            documento1 = fileNameArray[0].substring(3);
        }
        documento1 = documento1.replace("_", "");
        return documento1;
    }

}
