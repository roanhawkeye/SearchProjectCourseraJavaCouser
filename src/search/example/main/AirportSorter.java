package search.example.main;

import search.example.model.Airport;

public class AirportSorter {
	
	public static void selectionSort(Airport[] unsortedAirports){
		int indexMin;
		
		for(int i=0;i< unsortedAirports.length;i++){
			indexMin = i;
			for(int j=i+1; j < unsortedAirports.length; j++){
				if(unsortedAirports[j].getCity().compareTo(unsortedAirports[indexMin].getCity()) < 0){
					indexMin = j;
				}
			}
			
			swap(unsortedAirports, indexMin, i);
		}
		
	}

	private static void swap(Airport[] airports, int indexMin, int i) {
		// TODO Auto-generated method stub
		Airport smallest = airports[indexMin];
		Airport current = airports[i];
		airports[i] = smallest;
		airports[indexMin] = current;
	}
	
	public static void insertionSort(Airport[] airports){
		int currInd;
		for(int pos=1; pos < airports.length; pos++){
			currInd = pos;
			while(currInd > 0 && (airports[currInd].getCity().compareTo(airports[currInd-1].getCity()) < 0)){
				swap(airports, currInd, currInd-1);
				currInd = currInd - 1;
			}
		}
		
	}

}
