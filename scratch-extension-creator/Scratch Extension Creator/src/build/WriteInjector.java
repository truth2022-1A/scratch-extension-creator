/*
This class was created by colinator27.
This code injects scripts for Chrome extensions.
This class is part of Scratch Extension Creator.
*/


package build;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteInjector {
	private static void writeInjector() throws FileNotFoundException{
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
		new File(path+"/Extension Build").mkdirs();
		
		File file = new File(path+"/Extension Build/injectScripts.js");
		PrintWriter writer = new PrintWriter(file);
		writer.println("document.addEventListener('DOMContentLoaded', function() {");
		writer.println("	var extensionURL = chrome.extension.getURL(\"MainScript.js\");");
		writer.println("	var script = document.createElement(\"script\");");
		writer.println("	script.innerHTML = \"try {$.when(window.SWFready).done(function() { try { if (JSsetProjectStats) { var bak = JSsetProjectStats; JSsetProjectStats = function(a,b,c,d) { var script = document.createElement(\\"+"\"script\\"+"\");script.src = \\"+"\"\" + extensionURL + \"\\"+"\"; document.body.appendChild(script); return bak(a,b,c,d); }}} catch (e) {}});} catch (e) {}\";");
		writer.println("	document.body.appendChild(script);");
		writer.println("});");
		writer.close();
	}
	public static void write() throws FileNotFoundException{
		writeInjector();
	}
}
