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
	
	
	public void getMenorCaminho() {
		if (vertices.size() < 2) {
			System.out.println("Não existem pontos suficientes");
		}
		else {
			ArrayList<Elemento> S = new ArrayList<Elemento>();
			Vertice primeiro = vertices.get(0);
			S.add(new Elemento(primeiro, 0, 0, true));
			int posicao = -1;
			int valor = 99999999;
			int qtdElementos = vertices.size() - 1;
			
			for (Vertice vertice : vertices) {
				Aresta a = arestas[vertices.indexOf(primeiro)][vertices.indexOf(vertice)];
				
				if (vertices.indexOf(vertice) != vertices.indexOf(primeiro) && a != null) {
					int temp = a.getElemento();
					S.add(new Elemento(vertice, temp, vertices.indexOf(primeiro), false));
					
					if (temp < valor) {
						posicao = vertices.indexOf(vertice);
					}
				}
			}
			S.get(posicao).setCheck(true);
			-- qtdElementos;
			
			Elemento anterior = S.get(posicao);
			Vertice W = S.get(posicao).getVertice();
			int d = S.get(posicao).getValor();
			valor = 99999999;
			
			while (qtdElementos > 0) {
				for (Elemento elemento : S) {
					if (!elemento.isCheck()) {
						Aresta a = arestas[vertices.indexOf(primeiro)][vertices.indexOf(anterior.getVertice())];
						Aresta b = arestas[vertices.indexOf(anterior.getVertice())][vertices.indexOf(elemento.getVertice())];
						
						if (vertices.indexOf(elemento.getVertice()) != vertices.indexOf(primeiro) &&
							a != null && b != null) {
							if (elemento.getValor() > a.getElemento() + b.getElemento()) {
								elemento.setPosicao(vertices.indexOf(anterior.getVertice()));
								elemento.setValor(a.getElemento() + b.getElemento());
								
								if (elemento.getValor() < valor) {
									posicao = vertices.indexOf(elemento.getVertice());
								}
								
							}
						}
					}
				}
				S.get(posicao).setCheck(true);
				-- qtdElementos;
			}
		}
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
		for (int i = 0; i < qtdVertices - 1; i++) {
			for (int j = 0; j < qtdVertices - 1; j++) {
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
				
				if (i > indiceVertice && j > indiceVertice) {
					arestasTemp[i-1][j-1] = arestas[i][j];
				}
				else if (i > indiceVertice) {
					arestasTemp[i-1][j] = arestas[i][j];
				}
				else if (j > indiceVertice) {
					arestasTemp[1][j-1] = arestas[i][j];
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
		
		Aresta arestaTemp = arestas[indiceOrigem][indiceDestino];
		arestaTemp.setVerticeOrigem(null);
		arestaTemp.setVerticeDestino(null);
		
		arestas[indiceOrigem][indiceDestino] = arestas[indiceDestino][indiceOrigem] = null;
		
		return arestaTemp.getElemento();
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
	
	
	// Dijkstra
	

}