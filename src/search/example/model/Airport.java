package search.example.model;

public class Airport implements Comparable<Airport>{

	private String city;
	private String country;
	private String code3;
	
	
	public Airport(){
		
	}
	
	public Airport(String city, String country, String code3) {
		this.city = city;
		this.country = country;
		this.code3 = code3;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode3() {
		return code3;
	}
	public void setCode3(String code3) {
		this.code3 = code3;
	}

	@Override
	public String toString() {
		return "City: " + city + ", Country: " + country + ", Code: " + code3;
	}

	@Override
	public int compareTo(Airport o) {
		return city.compareTo(o.getCity());
	}
	
	
	
}
