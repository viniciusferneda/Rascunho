package L1323B28;

/**
 * Classe de processamento da �rvore
 * 
 * @author Vinicius Ferneda de Lima
 *
 */
public class ArvoreBinaria {

	private NoArvoreBinaria raiz;
	
	/**
	 * Chamada de m�todo para inserir informa��es na �rvore
	 * 
	 * @param info Informa��o a ser inserida na �rvore
	 */
	public void insere(String info) {
		if (raiz == null){
			raiz = new NoArvoreBinaria(info);
		}else{
			insere(raiz, info);
		}
	}
	
	/**
	 * Chamada de m�todo utilizando a recursividade para inserir informa��es na �rvore
	 * 
	 * @param no N� da �rvore
	 * @param info Informa��o a ser inserida na �rvore
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
	 * Impress�o das informa��es da �rvore
	 * 
	 * @return
	 */
	public String arvore() {
		String arvore = "";
		if (raiz == null){
			return "A �rvore n�o cont�m informa��es!";
		}else{ 
			arvore = arvore(raiz);
		}
		return arvore;
	}
	
	/**
	 * Impress�o das informa��es da �rvore de forma recursiva
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
