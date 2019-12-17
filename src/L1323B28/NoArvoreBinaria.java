package L1323B28;

/**
 * Classe de estrutura da árvore
 * 
 * @author Vinicius Ferneda de Lima
 *
 */
public class NoArvoreBinaria {

	private String info;
	private NoArvoreBinaria esq; 
	private NoArvoreBinaria dir;
	
	public NoArvoreBinaria(String info) {
		this.info = info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setEsq(NoArvoreBinaria esq) {
		this.esq = esq;
	}
	
	public NoArvoreBinaria getEsq() {
		return esq;
	}
	
	public void setDir(NoArvoreBinaria dir) {
		this.dir = dir;
	}
	
	public NoArvoreBinaria getDir() {
		return dir;
	}
	
}
