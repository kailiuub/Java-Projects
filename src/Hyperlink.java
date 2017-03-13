import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Hyperlink {

	public static void main(String[] args) throws IOException {
		LinkScraper ls = new LinkScraper();
		ls.getLink();
		
		System.out.println("done");
	}

}
