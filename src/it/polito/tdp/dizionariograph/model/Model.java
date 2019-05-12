package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {

	private Graph<String, DefaultEdge> grafo;
	private ArrayList<String> parole;

	public Graph<String, DefaultEdge> getGrafo() {
		return grafo;
	}

	public void createGraph(int numeroLettere) {

		this.grafo = new SimpleGraph<>(DefaultEdge.class);

		WordDAO wordDAO = new WordDAO();
		this.parole = new ArrayList<String>(wordDAO.getAllWordsFixedLength(numeroLettere));

		Graphs.addAllVertices(this.grafo, this.parole);

		int differenze = 0;

		for (String parola1 : parole) {
			for (String parola2 : parole) {
				if (!parola1.equals(parola2)) {
					differenze = 0;
					for (int i = 0; i < parola1.length(); i++) {
						if (parola1.charAt(i) != parola2.charAt(i)) {
							differenze++;
						}
					}
					if (differenze <= 1) {
						this.grafo.addEdge(parola1, parola2);
					}
				}

			}
		}

	}

	public List<String> displayNeighbours(String parolaInserita) {

		ArrayList<String> vicini = new ArrayList<String>();

		for (String parola : parole) {
			if (this.grafo.containsEdge(parolaInserita, parola))
				vicini.add(parola);
		}

		return vicini;
	}

	public int findMaxDegree() {
		
		int max = -1;
		
		for (String parola : parole) {
			if (this.displayNeighbours(parola).size()>max)
				max = this.displayNeighbours(parola).size();
		}
		
		return max;
	}
}
