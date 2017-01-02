package search.example.main;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import search.example.model.Airport;
import search.example.spliterator.AirportSpliterator;

public class Searcher {

	public static void main(String[] args) {
		
		Path path = Paths.get("data/airports.dat");
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter city name: ");
		String toFindCity = scan.next();
		
		//Use spliterator to obtain stream of airports
		try {
			Stream<String> lines = Files.lines(path);
			
			Spliterator<String> lineSpliterator  = lines.spliterator();
			Spliterator<Airport> personSpliterator = new AirportSpliterator(lineSpliterator);
			
			Stream<Airport> airports = StreamSupport.stream(personSpliterator, false);
			Airport[] airportsArray = airports.toArray(Airport[]::new);
			List<Airport> airportsList = new ArrayList<Airport>(Arrays.asList(airportsArray));
			AirportSorter.insertionSort(airportsArray);
			Collections.sort(airportsList);
			airportsList.forEach(System.out::println);
			
			String airportCodeBinary = BinarySearchAirport.findAirportCodeByCity(toFindCity, airportsArray);
			System.out.println(airportCodeBinary);
			
			String airportCodeLinear = LinearSearchAirport.findAirportCode(toFindCity,  airportsArray);
			System.out.println(airportCodeLinear);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
