package l1323H28;

public class ProdCons extends Thread {
	private int produto = 0;
	private int producao = 0;
	private int produzidos = 0;
	private int finalizado = 0;
	private String linhaSerie = "";
	private String nome = "";
	private String estado = "PARADO";
	private Armazem armazemAnt = null;
	private Armazem armazemProx = null;
	private Listener l;
	
	public ProdCons(String linhaSerie, String nome) {
		this.linhaSerie = linhaSerie;
		this.nome = nome;
	}

	public void run() {
		while (finalizado == 0) {
			trabalha();
		}
	}
	
	public void trabalha() {
		try {
			produto = armazemAnt.retiraProduto();
			if (produto == 0) {
				parar();
				return;
			}
			estado = "CONSUMINDO/PRODUZINDO";
			while (producao <= produto) {
				producao++;
				sleep(100);
				atualizaListener();
			}
			armazemProx.insereProduto(produto);
			produzidos++;
			produto = 0;
			producao = 0;
			if (finalizado == 0) {
				estado = "PARADO";
			}
			atualizaListener();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setArmazemAnt(Armazem armazem) {
		this.armazemAnt = armazem;
	}

	public void setArmazemProx(Armazem armazem) {
		this.armazemProx = armazem;
	}

	private void atualizaListener() {
		l.atualiza(this);
	}

	public void setListener(Listener l) {
		this.l = l;
	}

	private void parar() {
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

	public String getLinhaSerie() {
		return linhaSerie;
	}

	public void setLinhaSerie(String linhaSerie) {
		this.linhaSerie = linhaSerie;
	}
	
}
