package l1323H28;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConsumidor extends JPanel implements Listener {

	private static final long serialVersionUID = 1L;
	private JLabel tituloP1 = new JLabel("Produto: ");
	private JLabel produto = new JLabel("0");
	private JLabel tituloP2 = new JLabel("Tempo de Consumo: ");
	private JLabel producao = new JLabel("0");
	private JLabel tituloP3 = new JLabel("Total Consumido: ");
	private JLabel produzidos = new JLabel("0");
	private JLabel estado = new JLabel();
	private Consumidor consumidor;
	private boolean titulo;
	
	public PanelConsumidor(int linhaSerie){
		linhaSeriePanel(linhaSerie);
		this.titulo = true;
	}
	
	private void linhaSeriePanel(int linhaSerie) {
		setLayout(new GridLayout(1, 1));
		add(new JLabel("Linha de série "+linhaSerie));
	}

	public PanelConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
		inicializaComp();
	}

	// Cria componentes.
	private void inicializaComp() {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
		setLayout(new GridLayout(5, 1));
		add(new JLabel("Consumidor:"));
		add(new JLabel(consumidor.getNome()));
		add(tituloP3);
		add(produzidos);
		add(tituloP1);
		add(produto);
		add(tituloP2);
		add(producao);
		add(estado);
		consumidor.setListener(this);
		atualiza(this.consumidor);
	}

	public void goStart() {
		consumidor.start();
	}

	public Consumidor getRefConsumidor() {
		return consumidor;
	}

	@Override
	public void atualiza(Object obj) {
		produto.setText(String.valueOf(consumidor.getProduto()));
		producao.setText(String.valueOf(consumidor.getProducao()));
		produzidos.setText(String.valueOf(consumidor.getProduzidos()));
		estado.setText(String.valueOf(consumidor.getEstado()));
	}

	public boolean isTitulo() {
		return titulo;
	}

	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}

}
