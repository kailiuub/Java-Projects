import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.*;
import java.io.*;

public class Hyperlink {

	public static void main(String[] args) throws IOException {
		String[][] array= new String[5][3];
		// Parse second level contents and save to array
		LinkScraper ls = new LinkScraper();
		ls.getLink(array);
		for (int i=0; i<5; i++) {
			System.out.printf("link: %s %ntitle: %s %ncontents: %s %n",array[i][0],array[i][1],array[i][2]);
			System.out.println("---------------");
		}
		// Save array to file
		SaveData sd = new SaveData("yahoo.txt");
		sd.append(array);
		
		System.out.println("done");
	}
}
