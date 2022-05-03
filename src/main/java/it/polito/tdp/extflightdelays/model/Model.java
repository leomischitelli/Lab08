package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.GraphIterator;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	
	private Map<Integer, Airport> idAeroporti;
	private ExtFlightDelaysDAO flightsDAO;
	private Graph<Airport, DefaultWeightedEdge> graph;
	
	public Model() {
		
		idAeroporti = new HashMap<Integer, Airport>();
		flightsDAO = new ExtFlightDelaysDAO();
	}
	
	public void creaGrafo(List<CoppiaAeroporti> coppie) {
		this.graph = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		for(CoppiaAeroporti c : coppie) {
			Graphs.addEdgeWithVertices(graph, c.getOriginAirport(), c.getDestinationAirport(), c.getAvgDistance());
			
		}
		
	}
	
	public String trovaDistanze(int distanzaMin) {
		ArrayList<Airport> aeroporti = new ArrayList<Airport>(flightsDAO.loadAllAirports());
		for(Airport a : aeroporti) {
			idAeroporti.put(a.getId(), a);
		}
		List<CoppiaAeroporti> coppie = new ArrayList<CoppiaAeroporti>(flightsDAO.loadAllFlightsDistance(distanzaMin, idAeroporti));
		creaGrafo(coppie);
		String output = "";
		output+="Numero totale di vertici: " + graph.vertexSet().size() + "\nNumero totale di archi: " + graph.edgeSet().size() + "\nLista Aerporti: \n";
		for(CoppiaAeroporti c : coppie) {
			output+=c.toString() + "\n";
		}
		
		return output;
		
		
	}
	

}




//simple weighted graph
//identity map di airport
//return il grafo