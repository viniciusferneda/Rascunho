package l1323H28;

public class Fila<Tipo extends Object> {

	private int ini; 
	private int fim;
	private int numelem;
	private int tamanho;
	Tipo array[];

	public Fila() {
	}

	public Fila(int tam) {
		this.ini = 0;
		this.fim = 0;
		this.numelem = 0;
		this.tamanho = tam;
		this.array = (Tipo[]) new Object[tam];
	}

	public boolean vazia() {
		if (numelem == 0)
			return true;
		return false;
	}

	public boolean cheia() {
		if (numelem == tamanho)
			return true;
		return false;
	}

	public void inserir(Tipo elem) {
		if (!cheia()) {
			array[fim] = elem;
			numelem++;
			fim++;
			if (fim == tamanho)
				fim = 0;
		} else {
		}
	}

	public Tipo remover() {
		Tipo temp = null;
		if (!vazia()) {
			temp = array[ini];
			array[ini] = null;
			ini++;
			numelem--;
			if (ini == tamanho)
				ini = 0;
		} else {
		}
		return temp;
	}

	public int getFim() {
		return fim;
	}

	public int getInicio() {
		return ini;
	}

}
