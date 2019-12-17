package l1323H28;

import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		System.out.println("L1323H28 – Vinicius Ferneda de Lima");
		System.out.println("------------------------------------");
		Console c = new Console();
		c.criaProd();
		c.criaProdCons();
		c.criaCons();

		JanelaPrincipal j = new JanelaPrincipal(c.getLObjetos());
		j.setVisible(true);
	}
}
