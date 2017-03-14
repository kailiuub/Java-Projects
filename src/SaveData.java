import java.util.*;
import java.io.*;

public class SaveData {
	private String filepath;
	// constructor with file name as args
	SaveData(String fn) {
		//generate file address
		filepath=System.getProperty("user.dir")+"/" + fn;
		//check if exists
		File x = new File (filepath);
		if (x.exists())
			System.out.println(x.getName()+" exists already");
		//create file
		else { 
			Formatter form;
			try {
				form = new Formatter (filepath);
				System.out.printf("%s is created%n",filepath);
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
			for (int i=0; i<5; i++) {
				out.printf("link: %s %ntitle: %s %ncontents: %s %n%n",s[i][0],s[i][1],s[i][2]);
			}
		out.close();
		System.out.println("contents are appended");	
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
}
