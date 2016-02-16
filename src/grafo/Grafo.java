package grafo;

import java.util.ArrayList;

public class Grafo {
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	
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
	
	
	/*
	 * Atualizadores
	 * */
	
	public Vertice inserirVertice(int elemento) {
		Vertice vertice = new Vertice(elemento);
		vertices.add(vertice);
		return vertice;
	}
	
	public Aresta inserirAresta(Vertice vertice1, Vertice vertice2, int elemento) {
		Aresta aresta = new Aresta(elemento);
		aresta.setVertice1(vertice1);
		aresta.setVertice2(vertice2);
		arestas.add(aresta);
		return aresta;
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
		return arestas;
	}
}