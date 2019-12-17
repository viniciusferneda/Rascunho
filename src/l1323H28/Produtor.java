package l1323H28;

public class Produtor extends Thread {
	
	private int produto = 0;
	private int producao = 0;
	private int produzidos = 0;
	private int finalizado = 0;
	private String nome = "";
	private String estado = "PARADO";
	private Armazem armazemProx = null;
	private Listener lListeners;
	
	public Produtor(String nome) {
		this.nome = nome;
	}

	public void run() {
		while (finalizado == 0) {
			trabalha();
		}
	}

	public void trabalha() {
		try {
			int numero = (int) ((Math.random() * 150) + 50);
			produto = numero;
			estado = "PRODUZINDO";
			for (int i = 0; i < numero + 1; i++) {
				producao++;
				sleep(100);
				atualizaListener();
			}
			produzidos++;
			produto = 0;
			producao = 0;
			if (finalizado == 0) {
				estado = "PARADO";
			}
			atualizaListener();
			armazemProx.insereProduto(numero);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setArmazemProx(Armazem armazem) {
		armazemProx = armazem;
	}

	private void atualizaListener(){
		lListeners.atualiza(this);
	}

	public void setListener(Listener l) {
		this.lListeners = l;
	}

	public void parar() {
		finalizado = 1;
		estado = "FINALIZADO";
		atualizaListener();
	}

	public int getProduto() {
		return produto;
	}

	public int getProducao() {
		return producao;
	}

	public int getProduzidos() {
		return produzidos;
	}

	public String getEstado() {
		return estado;
	}

	public String getNome() {
		return nome;
	}

}
