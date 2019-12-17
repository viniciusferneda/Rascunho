package normalizacao.unimed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NormalizacaoUnimed {

	public static void main(String[] args) {
		try{  	
            BufferedReader br = new BufferedReader(new FileReader("C:\\workspace\\Rascunho\\src\\normalizacao\\unimed\\unimeds.txt"));  
            while(br.ready()){  
                String linha = br.readLine();
                String[] unimed = linha.split(";");
                Integer cdUnimed = Integer.valueOf(unimed[0]);
                String nmUnimed = unimed[1];
                //nmUnimed = nmUnimed.replace("Unimed de", "");
                //nmUnimed = nmUnimed.replace("Unimed", "");
                //nmUnimed = nmUnimed.replace("UNIMED", "");
                String[] nomes = nmUnimed.split(" ");
                String nmUnimedAbrev = "";
                for (int i = 0; i < nomes.length; i++) {
                	if("".equals(nomes[i])){
                		continue;
                	}
                	if("Federacao".equals(nmUnimedAbrev) || "Federação".equals(nmUnimedAbrev) || "FEDERACAO".equals(nmUnimedAbrev)){
                		nmUnimedAbrev = "Fed.";
                	}else if("Confederação".equalsIgnoreCase(nmUnimedAbrev)){
                		nmUnimedAbrev = "Conf.";
                	}
                	if("".equals(nmUnimedAbrev)){
                		String primeiraLetra = nomes[i].substring(0, 1);
                		nmUnimed = nomes[i].toLowerCase();
                		nmUnimedAbrev += nmUnimed.replaceFirst(primeiraLetra.toLowerCase(), primeiraLetra.toUpperCase());
                	}else{
                		String primeiraLetra = nomes[i].substring(0, 1);
                		nmUnimed = nomes[i].toLowerCase();
                		nmUnimedAbrev += " "+nmUnimed.replaceFirst(primeiraLetra.toLowerCase(), primeiraLetra.toUpperCase());
                	}
				}
                System.out.println("UPDATE UNIMED U SET U.ABREVIATURA = '"+nmUnimedAbrev+"' WHERE U.CD_UNIMED = "+cdUnimed+";");
            }  
            br.close();  
        }catch(IOException ioe){  
            ioe.printStackTrace();  
        }  
	}

}
