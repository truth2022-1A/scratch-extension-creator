//Note that this code has been deprecated. It isn't used anymore... it was replaced with a URL system. :(

package build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteAboutText {
	private static void writeAbout(String text) throws FileNotFoundException{
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		new File(path+"/Extension Build").mkdirs();
		
		File file = new File(path+"/Extension Build/about.txt");
		PrintWriter writer = new PrintWriter(file);
		writer.println(text);
		writer.close();
	}
	
	public static void write(String text) throws FileNotFoundException{
		writeAbout(text);
	}
}
