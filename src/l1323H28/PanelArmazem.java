package l1323H28;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelArmazem extends JPanel implements Listener {
	
	private static final long serialVersionUID = 1L;
	Armazem armazem;
	JPanel panelArmazem = new JPanel();
	private int serie;

	public PanelArmazem(Armazem armazem, int serie) {
		this.armazem = armazem;
		this.serie = serie;
		inicializaComp();
	}

	private void inicializaComp() {
		GridLayout layout = new GridLayout(armazem.getTamanho(), 1);
		layout.setHgap(40);
		panelArmazem.setLayout(layout);
		panelArmazem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Armazem "+serie));
		int pos = 1;
		while (pos <= armazem.getTamanho()) {
			JLabel l1 = new JLabel(" ");
			JLabel l2 = new JLabel(Integer.toString(pos));
			JLabel l3 = new JLabel(" ");
			// padrão de nomeclatura 1i 1f 2i 2f...
			l1.setName(Integer.toString(pos-1) + "i");
			l3.setName(Integer.toString(pos-1) + "f");
			panelArmazem.add(l1);
			panelArmazem.add(l2);
			panelArmazem.add(l3);
			pos++;
		}
		add(panelArmazem);
		armazem.setListener(this);
		
		atualiza(this.armazem);
	}

	public void atualiza(Object obj) {
		for (int i = 0; i < panelArmazem.getComponents().length; i++) {
			if (">".equals(((JLabel) panelArmazem.getComponents()[i]).getText())) {
				((JLabel) panelArmazem.getComponents()[i]).setText(" ");
				continue;
			}
			if ("<".equals(((JLabel) panelArmazem.getComponents()[i]).getText())) {
				((JLabel) panelArmazem.getComponents()[i]).setText(" ");
				continue;
			}
		}
		for (int i = 0; i < panelArmazem.getComponents().length; i++) {
			if ((armazem.getIni() + "i").equals(panelArmazem.getComponents()[i].getName())) {
				((JLabel) panelArmazem.getComponents()[i]).setText(">");
				continue;
			}
			if ((armazem.getFim() + "f").equals(panelArmazem.getComponents()[i].getName())) {
				((JLabel) panelArmazem.getComponents()[i]).setText("<");
				continue;
			}
		}
	}

}
