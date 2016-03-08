package grafo;

public class Main {

	public static void main(String[] args) {
		int indice = 0;
		int[] elementos = {1,2,3,4,5};
		
		System.out.println(elementos[++indice]);
		
		GrafoSimples gs = new GrafoSimples();
		gs.leArquivo("grafo.txt");
		System.out.println(gs.arestas().toString());
	}

}
