package search.example.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

import search.example.model.Airport;

public class AirportSpliterator implements Spliterator<Airport>{
	
	private final Spliterator<String> lineSpliterator;
	private String city;
	private String country;
	private String code3;
	
	public AirportSpliterator(Spliterator<String> lineSpliterator){
		this.lineSpliterator = lineSpliterator;
	}
	
	
	@Override
	public boolean tryAdvance(Consumer<? super Airport> action) {
		if(this.lineSpliterator.tryAdvance(line -> {
			String[] data = line.split(",");
			this.city = data[2];
			this.country = data[3];
			this.code3 = data[4];
		})){
			Airport a = new Airport(city, country, code3);
			action.accept(a);
			return true;
			
		}
		return false;
	}

	@Override
	public Spliterator<Airport> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return this.lineSpliterator.estimateSize();
	}

	@Override
	public int characteristics() {
		return this.lineSpliterator.characteristics();
	}
	
	

}
