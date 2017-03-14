public enum LocationEnum {
	Yahoo("Yah","https://www.yahoo.com/");
	
		
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
