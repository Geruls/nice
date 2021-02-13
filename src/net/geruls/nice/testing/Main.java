package net.geruls.nice.testing;
import java.io.IOException;
import net.geruls.nice.*;
import net.geruls.nice.exception.InternetException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		final ReadGithubFile rgf = new ReadGithubFile();
		System.out.println("Debugging...");
		try {
			rgf.GetRaw();
		} catch (InternetException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(RunShell.isWindows());
		System.out.println(RunShell.hi());
		

	}

}
