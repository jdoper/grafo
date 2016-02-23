package grafo;

import java.util.ArrayList;

public class GrafoSimples {
	private ArrayList<Vertice> vertices;
	private Aresta[][] arestas;
	private int qtdVertices;
	
	public GrafoSimples() {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new Aresta[0][0];
		this.qtdVertices = 0;
	}
	
	/*
	 * Acessadores
	 * */
	
	public Object[] finalVertices(Aresta aresta) {
		return null;
	}
	
	public Vertice oposto(Vertice vertice, Aresta aresta) {
		return aresta.oposto(vertice);
	}
	
	public boolean isAdjacente(Vertice vertice1, Vertice vertice2) {
		return false;
	}
	
	public void substituir(Vertice vertice, int elemento) {
		vertice.setElemento(elemento);
	}
	
	public void substituir(Aresta aresta, int elemento) {
		aresta.setElemento(elemento);
	}
	
	public int ordem() {
		return vertices.size();
	}
	
	
	/*
	 * Atualizadores
	 * */
	
	public Vertice inserirVertice(int elemento) {
		Vertice vertice = new Vertice(elemento);
		vertices.add(vertice);
		return vertice;
	}
	
	public Aresta inserirAresta(Vertice vertice1, Vertice vertice2, int elemento) {
		return null;
	}
	
	public Object removerVertice(Vertice vertice) {
		return null;
	}
	
	public Object removerAresta(Aresta aresta) {
		return null;
	}
	
	
	/*
	 * Interadores
	 * */
	
	public Object[] arestasIncidentes(Vertice vertice) {
		return null;
	}
	
	public ArrayList<Vertice> vertices() {
		return vertices;
	}
	
	public ArrayList<Aresta> arestas() {
		return null;
	}
}