package l1323H28;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelProdutor extends JPanel implements Listener{

	private JLabel tituloP1 = new JLabel("Produto: ");
	private JLabel produto = new JLabel("0");
	private JLabel tituloP2 = new JLabel("Tempo de Produção: ");
	private JLabel producao = new JLabel("0");
	private JLabel tituloP3 = new JLabel("Total Produzido:");
	private JLabel produzidos = new JLabel("0");
	private JLabel estado = new JLabel();
	private Button encerra = new Button("Encerrar Produção");
	private Produtor produtor;
	private boolean titulo;
	
	public PanelProdutor(int linhaSerie){
		linhaSeriePanel(linhaSerie);
		this.titulo = true;
	}
	
	private void linhaSeriePanel(int linhaSerie) {
		setLayout(new GridLayout(1, 1));
		add(new JLabel("Linha de série "+linhaSerie));
	}
	
	public PanelProdutor(Produtor produtor){
		this.produtor = produtor;
		inicializaComp();
		this.titulo = false;
	}

	private void inicializaComp(){
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
		setLayout(new GridLayout(6,2));
		add(new JLabel("Produtor:"));
		add(new JLabel(produtor.getNome()));
		add(tituloP3);
		add(produzidos);
		add(tituloP1);
		add(produto);
		add(tituloP2);
		add(producao);
		add(new JLabel("Status:"));
		add(estado);
		add(encerra);
		produtor.setListener(this);
		atualiza(this.produtor);
		click();
	}
	
	public void goStart(){
		produtor.start();
	}
	
	public Produtor getRefProd(){
		return produtor;
	}
	
	public void click(){
		encerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encerra.setEnabled(false);
				produtor.parar();
			}
		});
	}
	
	@Override
	public void atualiza(Object obj) {
		produto.setText(String.valueOf(produtor.getProduto()));
		producao.setText(String.valueOf(produtor.getProducao()));
		estado.setText(String.valueOf(produtor.getEstado()));
		produzidos.setText(String.valueOf(produtor.getProduzidos()));
	}

	public boolean isTitulo() {
		return titulo;
	}

	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}
	
}
