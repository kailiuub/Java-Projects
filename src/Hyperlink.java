import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.*;
import java.io.*;

public class Hyperlink {

	public static void main(String[] args) throws IOException {
		String[][] array;
		Document d = Jsoup.connect("https://www.craigslist.org").timeout(6000).get();
		LinkScraper ls = new LinkScraper();
		array=ls.getLink();
		System.out.println(array);
		
		System.out.println("done");
	}

}
