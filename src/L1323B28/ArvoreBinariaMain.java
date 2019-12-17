package L1323B28;

import java.util.Scanner;

/**
 * Classe de execução
 * 
 * @author Vinicius Ferneda de Lima
 *
 */
public class ArvoreBinariaMain {

	public static void main(String[] args) {

		System.out.println("L1323B28 – Vinícius Ferneda de Lima");

		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		Scanner console = new Scanner(System.in);
		
		String nome = console.nextLine();
		while (!"".equals(nome.trim())) {
			arvoreBinaria.insere(nome);
			nome = console.nextLine();
		}
		console.close();

		System.out.println(arvoreBinaria.toString());
	}
}
