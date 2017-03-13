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
	LinkScraper(){
		// push 1st urls to q
		for (LocationEnum l : LocationEnum.values()) {
			q.offer(l.getHttp());
		}
	}
	
	//extract first level urls
	public void getLink() throws IOException{
		while (!q.isEmpty()) {
			// Extract html code
			String url=q.poll();
			Document d = Jsoup.connect(url).timeout(6000).get();
			// Extract hyperlinks
			Elements ele = d.select("div#center");
			Elements links = ele.select("li");
			for (Element item : links.select("a[href]")) {
				// Select Hyperlink
				String link=item.attr("href");
				
				// Put 2nd level links (/search/...) to another queue
				if (link.startsWith("/search")){
					qq.offer(url+link);
				}
			}
		}
		while (!qq.isEmpty()) {	
			// Parsing contents at 2nd level
			String url2 = qq.poll();
			Document d2 = Jsoup.connect(url2).timeout(6000).get();
			String[][] arr = new String[5000][3];
			Elements ele2 = d2.select("p.result-info");
			int i = 0;
			for (Element e2 : ele2) {
				// title
				String t2 = e2.text();
				// links
				String link2 = e2.select("a").attr("href");
				arr[i][0]=url2;
				arr[i][1]=link2;
				arr[i][2]=t2;
				System.out.printf("%s-%s-%s %n",arr[i][0],arr[i][1],arr[i][2]);
				i++;
				
			}
			
		}
		
	}
}
	
