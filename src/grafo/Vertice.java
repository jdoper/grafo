package grafo;

public class Vertice {
	public int elemento;
	private int chave;
	
	/*
	 * Construtores
	 * */
	
	public Vertice(int elemento) {
		super();
		this.elemento = elemento;
	}
	
	
	/*
	 * Acessadores
	 * */
	
	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
}
