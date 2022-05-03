package it.polito.tdp.extflightdelays.model;

public class CoppiaAeroporti {
	
	private Airport originAirport;
	private Airport destinationAirport;
	private double avgDistance;
	
	public CoppiaAeroporti(Airport originAirport, Airport destinationAirport, double avgDistance) {
		super();
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.avgDistance = avgDistance;
	}
	
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public double getAvgDistance() {
		return avgDistance;
	}
	public void setAvgDistance(double avgDistance) {
		this.avgDistance = avgDistance;
	}

	@Override
	public String toString() {
		return originAirport.getAirportName() + "-" + destinationAirport.getAirportName() + " = " + avgDistance; 
	}
	
	
	
	
	
	

}
