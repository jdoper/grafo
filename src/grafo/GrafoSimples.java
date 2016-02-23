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
	
	public Vertice[] finalVertices(Aresta aresta) {
		return new Vertice[] {aresta.getVerticeOrigem(), aresta.getVerticeDestino()};
	}
	
	public Vertice oposto(Vertice vertice, Aresta aresta) {
		return aresta.oposto(vertice);
	}
	
	/*
	 * Busca os indices dos vertices e verifica se existe uma aresta
	 * na posição onde os vertices se encontram na matriz
	 * */
	public boolean isAdjacente(Vertice vertice1, Vertice vertice2) {
		int indiceVertice1 = vertices.indexOf(vertice1);
		int indiceVertice2 = vertices.indexOf(vertice2);
		
		if (arestas[indiceVertice1][indiceVertice2] != null) {
			return true;
		}
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
		
		qtdVertices++;
		Aresta[][] arestasTemp = new Aresta[qtdVertices][qtdVertices];
		for (int i = 0; i < qtdVertices; i++) {
			for (int j = 0; j < qtdVertices; j++) {
				arestasTemp[i][j] = arestas[i][j];
			}
		}
		arestas = arestasTemp;

		return vertice;
	}
	
	public Aresta inserirAresta(Vertice vertice1, Vertice vertice2, int elemento) {		
		int indiceVertice1 = vertices.indexOf(vertice1);
		int indiceVertice2 = vertices.indexOf(vertice2);
		
		Aresta aresta = new Aresta(elemento);
		arestas[indiceVertice1][indiceVertice2] = arestas[indiceVertice1][indiceVertice2] = aresta;
		
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
		return null;
	}
}