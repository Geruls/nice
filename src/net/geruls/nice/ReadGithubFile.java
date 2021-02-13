package net.geruls.nice;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import net.geruls.nice.exception.*;

public class ReadGithubFile {
	public void GetRaw() throws InternetException, IOException {
		URL url = GetURL(net.geruls.nice.api.ImplementInMain.getID());
		try {
			   Scanner s = new Scanner(url.openStream());
		        while(s.hasNextLine()){
		            String line = s.nextLine();
		            System.out.println(line);
		        }
			   
			   // read from your scanner
			} catch(IOException ex) {
			   throw new IllegalArgumentException("Repository ID invalid: Server returned Error 400 for URL " + url);
			}
	}
	private URL GetURL(String id) throws InternetException, IOException {
		URL url = null;
		try {
			url = new URL("https://raw.githubusercontent.com/" + id);
			if(net.geruls.nice.api.ImplementInMain.getID() == "") {
				throw new IllegalArgumentException("Repository ID is empty");
			}
		} catch (IOException e) {
			throw new InternetException("Failed to get files");
			// My father taught me to fight fire with fire -
			// In a different manner though...
		}
		return url;
	}
}
