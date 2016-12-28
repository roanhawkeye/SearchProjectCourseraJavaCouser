package search.example.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import search.example.model.Airport;
import search.example.spliterator.AirportSpliterator;

public class Searcher {

	public static void main(String[] args) {
		
		Path path = Paths.get("data/airports.dat");
		
		
		
		Airport[] airports = null;
		String toFindCity = "San Diego";
		
		//Use spliterator to obtain stream of airports
		try {
			Stream<String> lines = Files.lines(path);
			
			Spliterator<String> lineSpliterator  = lines.spliterator();
			Spliterator<Airport> personSpliterator = new AirportSpliterator(lineSpliterator);
			
			Stream<Airport> airports_ = StreamSupport.stream(personSpliterator, false);
			airports_.forEach(System.out::println);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String airportCode = LinearSearchAirport.findAirportCode(toFindCity, airports);
		
	}

}
