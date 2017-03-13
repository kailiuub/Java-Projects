

public enum LocationEnum {
	Buffalo("Buf","https://buffalo.craigslist.org"),
	NewYork("NYC","https://newyork.craigslist.org"),
	Syracuse("Syr", "https://syracuse.craigslist.org"),
	Corning("Cor", "https://corning.craigslist.org");
		
	private final String brief;
	private final String http;
	
	LocationEnum(String b, String h){
		brief=b;
		http=h;
	}	
	
	public String getBrief() {
		return brief;
	}
	
	public String getHttp() {
		return http;
	}
}
