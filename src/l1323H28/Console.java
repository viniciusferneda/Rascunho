package l1323H28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Console {

	List lObjetos = new ArrayList();
	Armazem pontArmazem = null;
	int serie = 1;
	Scanner console;

	public Console() {
		this.console = new Scanner(System.in);
	}

	public void criaProd() {
		List<PanelProdutor> lProdutores = new ArrayList<PanelProdutor>();
		List<PanelArmazem> lArmazens = new ArrayList<PanelArmazem>();
		int qtd = 0;
		
		lProdutores.add(new PanelProdutor(serie));
		try{
			System.out.print("Informe o número de produtores L"+serie+": ");
			qtd = Integer.valueOf(console.nextLine());
		}catch (NumberFormatException e) {
			System.out.print("ERRO - Informe um valor numérico para a quantidade de produtores L"+serie+": ");
			qtd = Integer.valueOf(console.nextLine());
		}
		for (int i = 0; i < qtd; i++) {
			PanelProdutor panelProdutor = new PanelProdutor(new Produtor(serie+"."+(String.valueOf(i+1))));
			lProdutores.add(panelProdutor);
		}
		lObjetos.add(lProdutores);

		try{
			System.out.print("Informe o número de áreas para armazenar produtos enviados pelos produtores L"+serie+": ");
			qtd = Integer.valueOf(console.nextLine());
		}catch (NumberFormatException e) {
			System.out.print("ERRO - Informe um valor numérico para a quantidade de áreas para armazenar produtos enviados pelos produtores L"+serie+":");
			qtd = Integer.valueOf(console.nextLine());
		}
		Armazem armazem = new Armazem(qtd);
		PanelArmazem panelA = new PanelArmazem(armazem, serie);
		lArmazens.add(panelA);
		for (PanelProdutor prod : lProdutores) {
			if(!prod.isTitulo()){
				prod.getRefProd().setArmazemProx(armazem);
			}
		}
		lObjetos.add(lArmazens);
		pontArmazem = armazem;
		serie++;
	}

	public void criaProdCons() {
		int qtd = 0;
		System.out.print("Informe o número de consumidores/produtores L"+serie+": ");
		String qtdStr = console.nextLine();
		while (!"".equals(qtdStr.trim())){
			List<PanelProdCons> lPanelProdCons = new ArrayList<PanelProdCons>();
			List<PanelArmazem> lPanelArmazem = new ArrayList<PanelArmazem>();
			
			lPanelProdCons.add(new PanelProdCons(serie));
			qtd = Integer.parseInt(qtdStr);
			for (int i = 0; i < qtd; i++) {
				ProdCons prodcons = new ProdCons("Linha de série "+serie, serie+"."+(String.valueOf(i+1)));
				PanelProdCons panelPC = new PanelProdCons(prodcons);
				prodcons.setArmazemAnt(pontArmazem);
				lPanelProdCons.add(panelPC);
			}
			lObjetos.add(lPanelProdCons);

			try{
				System.out.print("Informe número de áreas para armazenar produtos enviados pelo cons./prod. L"+serie+": ");
				qtd = Integer.valueOf(console.nextLine());
			}catch (NumberFormatException e) {
				System.out.print("ERRO - Informe um valor numérico para a quantidade de áreas para armazenar produtos enviados pelo cons./prod. L"+serie+": ");
				qtd = Integer.valueOf(console.nextLine());
			}
			Armazem armazem = new Armazem(qtd);
			PanelArmazem panelA = new PanelArmazem(armazem, serie);
			lPanelArmazem.add(panelA);
			for (PanelProdCons prod : lPanelProdCons) {
				if(!prod.isTitulo()){
					prod.getRefProdCons().setArmazemProx(armazem);
				}
			}
			lObjetos.add(lPanelArmazem);
			pontArmazem = armazem;
			serie++;
			System.out.print("Informe o número de consumidores/produtores L"+serie+": ");
			qtdStr = console.nextLine();
		}
	}

	public void criaCons() {
		List<PanelConsumidor> listaDeComponentesC = new ArrayList<PanelConsumidor>();
		listaDeComponentesC.add(new PanelConsumidor(serie));
		int qtd = 0;
		try{
			System.out.print("Informe o número de consumidores L"+serie+": ");
			qtd = Integer.valueOf(console.nextLine());
		}catch (NumberFormatException e) {
			System.out.print("ERRO - Informe um valor numérico para o número de consumidores L"+serie+":  ");
			qtd = Integer.valueOf(console.nextLine());
		}
		for (int i = 0; i < qtd; i++) {
			Consumidor c = new Consumidor("Linha de série "+serie, serie+"."+(String.valueOf(i+1)));
			c.setArmazemAnt(pontArmazem);
			PanelConsumidor panelC = new PanelConsumidor(c);
			listaDeComponentesC.add(panelC);
		}
		lObjetos.add(listaDeComponentesC);
		console.close();
	}

	public List getLObjetos() {
		return lObjetos;
	}
	
}
