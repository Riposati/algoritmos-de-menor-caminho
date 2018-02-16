package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Comparador implements Comparator<Vertice> {

	@Override
	public int compare(Vertice o1, Vertice o2) {

		if (o1.getDistancia() < o2.getDistancia()) {
			return -1;
		}
		if (o1.getDistancia() > o2.getDistancia()) {
			return 1;
		}
		return 0;
	}
}

public class Grafo {

	private List<Vertice> vertices;
	private PriorityQueue<Vertice> filaDeVertices;

	public Grafo() {
		this.vertices = new ArrayList<Vertice>(1000);
		this.filaDeVertices = new PriorityQueue<>(1000, new Comparador());
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void addVertice(Vertice v) {
		this.vertices.add(v);
	}

	public void mostraGrafo() {

		for (Vertice v : this.vertices) {

			System.out.println("\nV�rtice = " + v.getRotulo());
			if (v.getPrecedente() != null)
				System.out.println("\n**********Precedente = " + v.getPrecedente().getRotulo() + "****************");
			else
				System.out.println("\n**********Precedente = NULL" + "****************");

			System.out.println("\n**********ESTIMATIVA = " + v.getDistancia() + "****************");
		}
	}

	public void addAresta(Vertice verticeParteAresta, Vertice verticeRecebeAresta, long pesoAresta) {

		// Aqui temos um d�grafo

		boolean f1 = false;
		int aux1 = 0, i;

		for (i = 0; i < this.vertices.size() && !f1; i++) {

			if (this.vertices.get(i).getRotulo() == verticeParteAresta.getRotulo()) {
				f1 = true;
				aux1 = i;
			}
		}

		if (f1) {

			Aresta a = new Aresta();

			a.setRotuloVerticeVai(verticeRecebeAresta);
			a.setPesoAresta(pesoAresta);

			this.vertices.get(aux1).getListaArestas().add(a);
		}
	}

	private boolean acheiVertice(int rotulo) {

		for (int i = 0; i < this.getVertices().size(); i++) {

			if (this.getVertices().get(i).getRotulo() == rotulo) {
				this.getVertices().get(i).setDistancia(0); // O come�o da busca

				filaDeVertices.add(this.getVertices().get(i));

				return true;
			}
		}

		return false;
	}

	private void BFS(Vertice v) {

		for (int i = 0; i < v.getListaArestas().size(); i++) {

			Aresta a = v.getListaArestas().get(i);

			double sum = v.getDistancia() + a.getPesoAresta();

			if (sum < a.getRotuloVerticeVai().getDistancia()) {

				a.getRotuloVerticeVai().setDistancia(sum);
				a.getRotuloVerticeVai().setPrecedente(v);
				this.filaDeVertices.add(a.getRotuloVerticeVai());
			}
		}
	}

	public void dijkstra(char rotuloVerticeInicial) {

		System.out.println("Dijkstra");

		if (acheiVertice(rotuloVerticeInicial)) {

			while (filaNaoVazia()) {

				BFS(filaDeVertices.poll());
			}
		}
	}

	private boolean filaNaoVazia() {
		return !this.filaDeVertices.isEmpty();
	}

	public boolean bellmanFord(char rotuloVerticeInicial) {

		System.out.println("Bellman-Ford");

		// encontrar o vertice inicial
		for (int i = 0; i < this.getVertices().size(); i++) {
			if (this.getVertices().get(i).getRotulo() == rotuloVerticeInicial) {
				this.getVertices().get(i).setDistancia(0);
				break;
			}
		}

		boolean cicloNegativo = false;

		for (int z = 0; z < this.vertices.size(); z++) {

			for (int i = 0; i < this.vertices.size(); i++) {

				this.relaxamentoArestasBellmanFord(i, cicloNegativo); // n�o importa o ciclo negativo o primeiro
																		// relaxamento!
			}
		} // ate aqui e a parte do relaxamento

		cicloNegativo = false;
		boolean f = false;
		// verificacao ciclo negativo
		for (int i = 0; i < this.vertices.size() && !f; i++) {

			f = this.relaxamentoArestasBellmanFord(i, cicloNegativo); // se true ( achou ciclo negativo )
		}

		return f;
	}

	private boolean relaxamentoArestasBellmanFord(int i, boolean cicloNegativo) {

		for (int j = 0; j < this.vertices.get(i).getListaArestas().size(); j++) {

			double sum = this.vertices.get(i).getListaArestas().get(j).getPesoAresta()
					+ this.vertices.get(i).getDistancia();

			if (sum < this.vertices.get(i).getListaArestas().get(j).getRotuloVerticeVai().getDistancia()) {

				cicloNegativo = true;
				this.vertices.get(i).getListaArestas().get(j).getRotuloVerticeVai().setPrecedente(this.vertices.get(i));
				this.vertices.get(i).getListaArestas().get(j).getRotuloVerticeVai().setDistancia(sum);
			}
		}
		return cicloNegativo;
	}
}