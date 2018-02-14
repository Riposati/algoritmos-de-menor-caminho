package main;

import modelo.Grafo;
import modelo.Vertice;

public class Main {

	public static void main(String[] args) {

		int tam = 3;
		
		Vertice vs[] = new Vertice[tam];
		char vet[] = new char[tam];
//		vet = new char[] { 's', 't', 'x', 'z', 'y' }; // vetor para os exemplos do livro do cormen, OBS tam = 5*
		vet = new char[] {'u','v','w'}; // vetor para o exemplo do ciclo negativo, OBS tam = 3*

		Grafo g = new Grafo();

		for (int i = 0; i < vet.length; i++) {
			vs[i] = new Vertice(vet[i]);
			g.addVertice(vs[i]);
		}

		adicionadorArestas(vs, g);

		// Parte Dijkstra
		// g.dijkstra(vs[0].getRotulo());
		// g.mostraGrafo();

		// Parte Bellman-Ford
		if (g.bellmanFord(vs[0].getRotulo())) {
			System.out.println("\n\n****Não tem solução pois tem ciclo negativo****");
		} else {
			System.out
					.println("\n\n----Foi possível determinar o melhor caminho pois não encontrei ciclo negativo!----");
			g.mostraGrafo();
		}

	}

	private static void adicionadorArestas(Vertice[] vs, Grafo g) {

		// exemplo com ciclo negativo
		g.addAresta(vs[0], vs[1], 3);
		g.addAresta(vs[1], vs[2], 3);
		g.addAresta(vs[1], vs[0], -5);
		
		// exemplo do Bellman-Ford livro Cormen
//		g.addAresta(vs[0], vs[1], 6);
//		g.addAresta(vs[0], vs[4], 7);
//
//		g.addAresta(vs[1], vs[2], 5);
//		g.addAresta(vs[1], vs[3], -4);
//		g.addAresta(vs[1], vs[4], 8);
//
//		g.addAresta(vs[2], vs[1], -2);
//
//		g.addAresta(vs[3], vs[2], 7);
//		g.addAresta(vs[3], vs[0], 2);
//
//		g.addAresta(vs[4], vs[2], -3);
//		g.addAresta(vs[4], vs[3], 9);

		// exemplo do Dijkstra livro Cormen

		// g.addAresta(vs[0], vs[1], 10);
		// g.addAresta(vs[0], vs[4], 5);
		//
		// g.addAresta(vs[1], vs[2], 1);
		// g.addAresta(vs[1],vs[4], 2);
		//
		// g.addAresta(vs[2], vs[3], 4);
		//
		// g.addAresta(vs[3], vs[2], 6);
		// g.addAresta(vs[3], vs[0], 7);
		//
		// g.addAresta(vs[4], vs[1], 3);
		// g.addAresta(vs[4], vs[2], 9);
		// g.addAresta(vs[4], vs[3], 2);
	}
}
