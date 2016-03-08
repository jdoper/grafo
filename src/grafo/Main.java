package grafo;

public class Main {

	public static void main(String[] args) {	
		GrafoSimples gs = new GrafoSimples();
		gs.leArquivo("grafo.txt");
		// System.out.println(gs.getArestas().toString());
		
		gs.lerMatriz();
	}

}
