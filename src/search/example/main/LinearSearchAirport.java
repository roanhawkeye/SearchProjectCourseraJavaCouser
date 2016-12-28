package search.example.main;

import search.example.model.Airport;

public class LinearSearchAirport {
	
	
	public static String findAirportCode(String toFind, Airport[] airports){
		for(Airport aiport: airports){
			if(aiport.getCity().equalsIgnoreCase(toFind)){
				return aiport.getCode3();
			}
		}
		return null;
	}
}
