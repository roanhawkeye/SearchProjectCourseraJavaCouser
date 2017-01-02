package search.example.main;

import search.example.model.Airport;

public class BinarySearchAirport {

	public static String findAirportCodeByCity(String city, Airport[] airports){
		int low = 0;
		int high = airports.length -1;
		int mid;
		while(low <= high){
			mid = low + ((high - low)/2);
			int compare = city.compareTo(airports[mid].getCity());
			if(compare < 0){
				high = mid - 1;
			}else if(compare > 0){
				low = mid + 1;
			}else{
				return airports[mid].getCode3();
			}
		}
		
		return null;
	}
	
}
