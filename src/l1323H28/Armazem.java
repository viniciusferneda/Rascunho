package l1323H28;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Armazem {
	private Fila<Integer> fila;
	private Semaphore areasVazias;
	private Semaphore exclusividade;
	private Semaphore areasOcupadas;
	private int tamanho = 0;
	private Listener l;
	private int ini = 0;
	private int fim = 0;

	public Armazem(int tamanho) {
		fila = new Fila<Integer>(tamanho);
		this.tamanho = tamanho;
		areasVazias = new Semaphore(tamanho);
		exclusividade = new Semaphore(1);
		areasOcupadas = new Semaphore(0);
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void insereProduto(int produto) {
		try {
			areasVazias.acquire();
			exclusividade.acquire();

			fila.inserir(produto);
			// quando termina de produzir atualiza fim do armazem
			fim = fila.getFim();
			atualizaListener();
			areasOcupadas.release();
			exclusividade.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public int retiraProduto() {
		try {
			if (areasOcupadas.tryAcquire(60, TimeUnit.SECONDS) == false) {
				return 0;
			}
			exclusividade.acquire();

			int produto = fila.remover();

			areasVazias.release();
			exclusividade.release();
			// quando termina de consumir atualiza inicio do armazem
			ini = fila.getInicio();
			atualizaListener();
			return produto;

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void inicioA() {
		ini = fila.getInicio();
		atualizaListener();
	}

	public void fimA() {
		fim = fila.getFim();
		atualizaListener();
	}

	private void atualizaListener() {
		l.atualiza(this);
	}

	public void setListener(Listener l) {
		this.l = l;
	}

	public int getFim() {
		return fim;
	}

	public int getIni() {
		return ini;
	}
}
