/*This class was created by colinator27.
THIS WRITES TO FILE 'MainScript.js' IN THE OUTPUT.
This class is part of Scratch Extension Creator.*/

package build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WriteToScript {
	public static void writeMainScript(ArrayList<String> script) throws FileNotFoundException, UnsupportedEncodingException, URISyntaxException{
		int count = 0;
		
		//final File f = new File(MainFrame.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		//String path = f.toString().replaceAll("%20", " ");
		System.out.println("WriteToScript :: Opening file path...");
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		System.out.println("WriteToScript :: Found path!");
		new File(path+"/ScratchX Build").mkdirs();
		new File(path+"/Extension Build").mkdirs();
		System.out.println("WriteToScript :: Directories created/loaded.");
		File file = null;
		if(main.MainFrame.isChrome) {
			file = new File(path+"/Extension Build/MainScript.js");
		} else {
			file = new File(path+"/ScratchX Build/MainScript.js");
		}
		System.out.println("WriteToScript :: MainScript.js loaded.");
		PrintWriter writer = new PrintWriter(file);
		
		int countt = 1;
		while(count < script.size()){
			writer.println(script.get(count));
			System.out.println("WriteToScript :: Writing... ("+countt+" out of "+script.size()+")");
			count++;
			countt++;
		}
		writer.close();
	}
}
