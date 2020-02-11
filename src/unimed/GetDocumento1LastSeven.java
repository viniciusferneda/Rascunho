package unimed;

public class GetDocumento1LastSeven {

    public static void main(String[] args) {
        String documento1 = "123456";
        String documento1LastSeven;
        if(documento1.length() > 7){
            documento1LastSeven = documento1.substring(documento1.length()-7);
        }else{
            documento1LastSeven = documento1;
        }
        System.out.println(documento1LastSeven);
    }

}
