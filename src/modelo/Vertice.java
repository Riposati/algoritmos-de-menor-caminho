package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private char rotulo;
	private double distancia;
	private List<Aresta> listaArestas;
	//private boolean isAberto;
	private Vertice precedente;

	public Vertice(char rotulo) {
		this.rotulo = rotulo;
		this.distancia = Double.POSITIVE_INFINITY;
		//this.isAberto = true;
		this.listaArestas = new ArrayList<Aresta>(1000);
		this.precedente = null;
	}

	public void setPrecedente(Vertice v) {
		this.precedente = v;
	}

	public Vertice getPrecedente() {
		return this.precedente;
	}

//	public void setFechado() {
//		this.isAberto = false;
//	}

//	public boolean isAberto() {
//		return this.isAberto;
//	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public char getRotulo() {
		return rotulo;
	}

	public List<Aresta> getListaArestas() {
		return listaArestas;
	}
}
