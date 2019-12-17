package l1323H28;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelProdCons extends JPanel implements Listener{
	
	private static final long serialVersionUID = 1L;
	private JLabel tituloP1 = new JLabel("Produto: ");
	private JLabel produto = new JLabel("0");
	private JLabel tituloP2 = new JLabel("Tempo de Consumo/Produção: ");
	private JLabel producao = new JLabel("0");
	private JLabel tituloP3 = new JLabel("Total Consumido/Produzido: ");
	private JLabel produzidos = new JLabel("0");
	private JLabel estado = new JLabel();
	private ProdCons prodcons;
	private boolean titulo;
	
	public PanelProdCons(int linhaSerie){
		linhaSeriePanel(linhaSerie);
		this.titulo = true;
	}
	
	private void linhaSeriePanel(int linhaSerie) {
		setLayout(new GridLayout(1, 1));
		add(new JLabel("Linha de série "+linhaSerie));
	}

	public PanelProdCons(ProdCons prodcons){
		this.prodcons = prodcons;
		inicializaComp();
	}
	
	//Cria componentes.
	private void inicializaComp(){
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
		setLayout(new GridLayout(5,2));
		add(new JLabel("Prod/Cons:"));
		add(new JLabel(prodcons.getNome()));
		add(tituloP3);
		add(produzidos);
		add(tituloP1);
		add(produto);
		add(tituloP2);
		add(producao);
		add(estado);
		prodcons.setListener(this);
		atualiza(this.prodcons);
	}
	public void goStart(){
		prodcons.start();
	}
	public ProdCons getRefProdCons(){
		return prodcons;
	}
	
	public void atualiza(Object obj) {
		produto.setText(String.valueOf(prodcons.getProduto()));
		producao.setText(String.valueOf(prodcons.getProducao()));
		produzidos.setText(String.valueOf(prodcons.getProduzidos()));
		estado.setText(String.valueOf(prodcons.getEstado()));
		
	}

	public boolean isTitulo() {
		return titulo;
	}

	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}

}
