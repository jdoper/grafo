package grafo;

public class Aresta {
	public int elemento;
	public Vertice vertice1;
	public Vertice vertice2;
	
	/*
	 * Construtores
	 * */
	
	public Aresta(int elemento) {
		super();
		this.elemento = elemento;
	}


	/*
	 * Acessadores
	 * */
	
	public int getElemento() {
		return elemento;
	}

	public Vertice getVertice1() {
		return vertice1;
	}

	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}

	public Vertice getVertice2() {
		return vertice2;
	}

	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	
	public Vertice oposto(Vertice vertice) {
		if (vertice1.getElemento() == vertice.getElemento()) {
			return vertice2;
		}
		return vertice1;
	}
}
