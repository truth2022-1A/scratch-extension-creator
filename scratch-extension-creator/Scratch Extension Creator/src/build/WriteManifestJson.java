/*This class was created by colinator27.
THIS IS THE CHROME EXTENSION MANIFEST FILE.
This class is part of Scratch Extension Creator.*/

package build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteManifestJson {
	private static void WriteManifest(String title, String desc, String author) throws FileNotFoundException{
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		new File(path+"/Extension Build").mkdirs();
		
		File file = new File(path+"/Extension Build/manifest.json");
		PrintWriter writer = new PrintWriter(file);
		writer.println("{");
		writer.println("   \"author\": \""+author+"\",");
		writer.println("   \"content_scripts\": [ {");
		writer.println("      \"js\": [ \"injectScripts.js\" ],");
		writer.println("      \"matches\": [ \"https://scratch.mit.edu/*\", \"https://staging.scratch.mit.edu/*\" ],");
		writer.println("      \"run_at\": \"document_start\"");
		writer.println("   } ],");
		writer.println("   \"description\": \""+desc+"\",");
		writer.println("   \"manifest_version\": 2,");
		writer.println("   \"name\": \""+title+"\",");
		writer.println("   \"version\": \"1.0\",");
		writer.println("   \"version_name\": \"1.0.0\",");
		//Access to the web granted for user's extensions. :)
		writer.println("   \"web_accessible_resources\": [ \"MainScript.js\" ]");
		writer.println("}");
		writer.close();
	}
	public static void write(String title, String desc, String author) throws FileNotFoundException{
		WriteManifest(title, desc, author);
	}
}
