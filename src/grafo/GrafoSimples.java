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
		arestas[indiceVertice1][indiceVertice2] = arestas[indiceVertice2][indiceVertice1] = aresta;
		
		return aresta;
	};
	
	public int removerVertice(Vertice vertice) {
		int indiceVertice = vertices.indexOf(vertice);
	
		Aresta[][] arestasTemp = new Aresta[qtdVertices - 1][qtdVertices - 1];
		for (int i = 0; i < qtdVertices; i++) {
			// Pula a linha do Vertice na matriz de adjacencia
			if (i == indiceVertice) {
				i++;
				continue;
			}
			
			for (int j = 0; j < qtdVertices; j++) {
				// Pula a coluna do Vertice na matriz de adjacencia
				if (j == indiceVertice) {
					j++;
					continue;
				}
				
				if (j > indiceVertice) {
					arestasTemp[i][j-1] = arestas[i][j];
				}
				else {
					arestasTemp[i][j] = arestas[i][j];
				}
			}
		}
		arestas = arestasTemp;
		qtdVertices--;
		
		return vertice.getElemento();
	}
	
	public int removerAresta(Aresta aresta) {
		int indiceOrigem = vertices.indexOf(aresta.getVerticeOrigem());
		int indiceDestino = vertices.indexOf(aresta.getVerticeDestino());
		
		int elemento = arestas[indiceOrigem][indiceDestino].getElemento();
		arestas[indiceOrigem][indiceDestino] = arestas[indiceDestino][indiceOrigem] = null;
		
		return elemento;
	}
	
	
	/*
	 * Interadores
	 * */
	
	public ArrayList<Aresta> arestasIncidentes(Vertice vertice) {
		ArrayList<Aresta> arestasTemp = new ArrayList<Aresta>();
		int indiceVertice = vertices.indexOf(vertice);
		
		for (int i = 0; i < qtdVertices + 1; i++) {
			if (arestas[indiceVertice][i] != null) {
				arestasTemp.add(arestas[indiceVertice][i]);
			}
		}
		
		return arestasTemp;
	}
	
	public ArrayList<Vertice> vertices() {
		return vertices;
	}
	
	public ArrayList<Aresta> arestas() {
		ArrayList<Aresta> arestasTemp = new ArrayList<Aresta>();
		
		for (int i = 0; i < qtdVertices; i++) {
			for (int j = 0; j < qtdVertices; j++) {
				arestasTemp.add(arestas[i][j]);
			}
		}
		
		return arestasTemp;
	}
}