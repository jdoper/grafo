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
		return null;
	}
	
	public boolean isAdjacente(Vertice vertice1, Vertice vertice2) {
		return false;
	}
	
	public void substituir(Vertice vertice, Object elemento) {}
	
	public void substituir(Aresta aresta, Object elemento) {}
	
	
	/*
	 * Atualizadores
	 * */
	
	public Vertice inserirVertice(Object elemento) {
		return null;
	}
	
	public Aresta inserirAresta(Vertice vertice1, Vertice vertice2, Object elemento) {
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
	
	public Object[] vertices() {
		return null;
	}
	
	public Object[] arestas() {
		return null;
	}
}