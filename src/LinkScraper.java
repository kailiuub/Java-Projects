import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkScraper {
	//Set up a queue to hold first basic links
	PriorityQueue<String> q = new PriorityQueue<String>();
	//Set up a queue to hold second level links
	PriorityQueue<String> qq = new PriorityQueue<String>();
	//Define array to save extracted data
	LinkScraper(){
		// push 1st urls to q
		for (LocationEnum l : LocationEnum.values()) {
			q.offer(l.getHttp());
		}
	}
	
	//extract first level urls
	public void getLink(String[][] arr) throws IOException{
		while (!q.isEmpty()) {
			// Extract html code
			String url=q.poll();
			Document d = Jsoup.connect(url).timeout(6000).get();
			// Extract hyperlinks
			Elements ele = d.select("h3");
			for (Element item : ele.select("a[href]")) {
				// Select Hyperlink
				String link=item.attr("href");
				if (link.startsWith("https://www.yahoo.com")) {
					qq.offer(link);
				}	
				System.out.println(qq);
			}
		}
		int i = 0;
		while (!qq.isEmpty()) {	
			// Parsing contents at 2nd level
			String url2 = qq.poll();
			Document d2 = Jsoup.connect(url2).timeout(6000).get();
			Elements ele2 = d2.select("body");
			// extract title of each page
			String t2 = ele2.select("h1").text();
			String content = ele2.select("article").text();
			arr[i][0]=url2;
			arr[i][1]=t2;
			arr[i][2]=content;
			i++;
			}
	}
	
}
	
