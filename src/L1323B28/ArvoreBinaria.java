package L1323B28;

/**
 * Classe de processamento da Árvore
 * 
 * @author Vinicius Ferneda de Lima
 *
 */
public class ArvoreBinaria {

	private NoArvoreBinaria raiz;
	
	/**
	 * Chamada de método para inserir informações na árvore
	 * 
	 * @param info Informação a ser inserida na árvore
	 */
	public void insere(String info) {
		if (raiz == null){
			raiz = new NoArvoreBinaria(info);
		}else{
			insere(raiz, info);
		}
	}
	
	/**
	 * Chamada de método utilizando a recursividade para inserir informações na árvore
	 * 
	 * @param no Nó da árvore
	 * @param info Informação a ser inserida na árvore
	 */
	private void insere (NoArvoreBinaria no, String info) {
		if (info.compareTo(no.getInfo()) < 0) {
			if (no.getEsq() == null){
				no.setEsq(new NoArvoreBinaria(info));
			}else{
				insere(no.getEsq(), info);
			}
		} else {
			if (no.getDir() == null){
				no.setDir(new NoArvoreBinaria(info));
			}else{
				insere(no.getDir(), info);
			}
		}
	}
	
	@Override
	public String toString() {
		return arvore();
	}
	
	/**
	 * Impressão das informações da árvore
	 * 
	 * @return
	 */
	public String arvore() {
		String arvore = "";
		if (raiz == null){
			return "A árvore não contém informações!";
		}else{ 
			arvore = arvore(raiz);
		}
		return arvore;
	}
	
	/**
	 * Impressão das informações da árvore de forma recursiva
	 * 
	 * @param no
	 * @return
	 */
	private String arvore(NoArvoreBinaria no) {
		String arvore = "";

		if (no != null) {
			arvore += arvore(no.getEsq());
			arvore += "\n" + no.getInfo();
			arvore += arvore(no.getDir());
		}
		return arvore;
	}
	
}
