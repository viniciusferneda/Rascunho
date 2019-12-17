package l1323H28;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("rawtypes")
public class JanelaPrincipal extends JFrame{
    
	private static final long serialVersionUID = 1L;
	private List listaListas = null;
    private List<Consumidor> listaConsumidores = new ArrayList<Consumidor>();
	
	public JanelaPrincipal(List listaListas){
		setTitle("Produtor-Consumidor - L1323H28 – Vinicius Ferneda de Lima");
		setSize(1024,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
				
		this.listaListas = listaListas;
		inicializaComp();
	}
	
	private void inicializaComp(){
		JButton botao = new JButton("Informações Finais");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estatisticas();
			}
		});
		
		
		JPanel panel = new JPanel();
		
		List lista=null;
		for (Object umObj : listaListas) {
			lista = (List)umObj;
			JPanel p2 = new JPanel(new GridLayout(lista.size(), 1));
			for (Object umList : lista) {
				p2.add((Component) umList);
			}
			panel.add(p2);
		}
		
		JPanel p = new JPanel();
		p.add(panel);
		p.add(botao);
		JScrollPane scroll = new JScrollPane(p);
		add(scroll);
		disparaThreads();
	}
	
	private void disparaThreads(){
		List l;
		for (Object umObj : listaListas) {
			l = (List)umObj;
			for (Object umList : l) {
				if(umList.getClass().getName().compareTo("l1323H28.PanelProdutor") == 0){
					PanelProdutor pp = (PanelProdutor) umList;
					if(!pp.isTitulo()){
						pp.goStart();
					}
				}
				if(umList.getClass().getName().compareTo("l1323H28.PanelProdCons") == 0){
					PanelProdCons ppc = (PanelProdCons) umList;
					if(!ppc.isTitulo()){
						ppc.goStart();
					}
				}
				if(umList.getClass().getName().compareTo("l1323H28.PanelConsumidor") == 0){
					PanelConsumidor pc = (PanelConsumidor) umList;
					if(!pc.isTitulo()){
						pc.goStart();
						Consumidor consumidor = pc.getRefConsumidor();
						listaConsumidores.add(consumidor);
					}
				}
			}
		}
	}
	
	private void estatisticas(){
		System.out.println("------------------------------------");
		ArrayList l;
		for (Object umObj : listaListas) {
			l = (ArrayList) umObj;
			for (Object umList : l) {
				if(umList.getClass().getName().compareTo("l1323H28.PanelProdutor") == 0){
					PanelProdutor pp = (PanelProdutor) umList;
					if(!pp.isTitulo()){
						System.out.println("Produtos manuseados pelo PRODUTOR " + pp.getRefProd().getNome() + " .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  : " + pp.getRefProd().getProduzidos());
					}
				}
				if(umList.getClass().getName().compareTo("l1323H28.PanelProdCons") == 0){
					PanelProdCons ppc = (PanelProdCons) umList;
					if(!ppc.isTitulo()){
						System.out.println("Produtos manuseados pelo CONSUMIDOR/PRODUTOR " + ppc.getRefProdCons().getNome() + " .  .  .  .  .  .  : " + ppc.getRefProdCons().getProduzidos());
					}
				}
				if(umList.getClass().getName().compareTo("l1323H28.PanelConsumidor") == 0){
					PanelConsumidor pc = (PanelConsumidor) umList;
					if(!pc.isTitulo()){
						System.out.println("Produtos manuseados pelo CONSUMIDOR " + pc.getRefConsumidor().getNome() + "  .  .  .  .  .  .  .  .  .  .  .  .  .  : " + pc.getRefConsumidor().getProduzidos());
					}
				}
			}
		}
	}
}
