import java.util.*;
import java.io.*;

public class SaveData {
	private String filepath;
	// constructor with file name as args
	SaveData(String fn) {
		//generate file address
		filepath=System.getProperty("user.dir")+"/" + fn;
		System.out.println(filepath);
		//check if exists
		File x = new File (filepath);
		if (x.exists())
			System.out.println(x.getName()+" exists already");
		//create file
		else { 
			Formatter form;
			try {
				form = new Formatter (filepath);
				System.out.println("new file is created");
			}
			catch(Exception e) {
				System.out.println("error");
			}
		}				
	}
	
	public void append(String s[][]) {
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter out;
		try {
			fw = new FileWriter(filepath, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter (bw);
			for (int i=0; i<5000; i++) {
				out.printf("%s\t%s\t%s %n",s[i][0],s[i][1],s[i][2]);
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
}
