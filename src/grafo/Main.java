package grafo;

public class Main {

	public static void main(String[] args) {	
		GrafoSimples gs = new GrafoSimples(5);
		gs.lerArquivo("grafo.txt");
		gs.lerMatriz();
		
		System.out.println(gs.getMenorCaminho().toString());
	}
}
