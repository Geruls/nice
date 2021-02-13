package net.geruls.nice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class RunShell {
	private static class StreamGobbler implements Runnable {
	    private InputStream inputStream;
	    private Consumer<String> consumer;

	    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
	        this.inputStream = inputStream;
	        this.consumer = consumer;
	    }

	    @Override
	    public void run() {
	        new BufferedReader(new InputStreamReader(inputStream)).lines()
	          .forEach(consumer);
	    }
	}
	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().startsWith("windows");
	}
	public static Process hi() throws IOException, InterruptedException {
		String ADirectory = (System.getProperty("user.home") + "\\AppData\\Local");
		Process process;
		if (isWindows() == true) {
		    process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", ADirectory));
		    try {
		    	process = Runtime.getRuntime().exec(String.format("cmd.exe /c mkdir %s", (ADirectory + "\\Geruls\\Nice")));
		    } catch(Throwable e) {
		    	System.out.println("Oof");
		    }
		} else {
		    process = Runtime.getRuntime().exec(String.format("sh -c ls %s", ADirectory));
		}
		StreamGobbler streamGobbler = 
		  new StreamGobbler(process.getInputStream(), System.out::println);
		Executors.newSingleThreadExecutor().submit(streamGobbler);
		return process;
	}
	
}
