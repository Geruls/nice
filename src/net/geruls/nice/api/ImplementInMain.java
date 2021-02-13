package net.geruls.nice.api;

public class ImplementInMain {
	
	private static boolean useKeyVerification = false; // Use KeyVerify

	private static String REPO_ID = "GitFyu/KeystrokesBase/master/build.gradle"; // GitHub Repository ID, leave as it is
	// if you use KeyVerification instead of GitHubFileVerification.
	// e.g. Geruls/nice
	
	public static String getID() {
		return REPO_ID;
	}
	public static boolean getIntegrityMethod() {
		return useKeyVerification;
	}
	

}
