/*This class was created by colinator27.
This class is part of Scratch Extension Creator.*/

package build;

import java.util.ArrayList;

public class BuildScripts {
	public static ArrayList<String> compileScript(ArrayList<String> blockCode, String extName){
		ArrayList<String> scr = new ArrayList<String>();
		System.out.println("BuildScripts :: Writing script...");
		scr.add("(function (ext) {");
		scr.add("	var ExtName = '"+extName+"';");
		scr.add("	ext._shutdown = function() {};");
		scr.add("	ext._getStatus = function() {");
		scr.add("		return {status: 2, msg: 'Ready'};");
		scr.add("	};");
		int count = 0;
		while(count < blockCode.size()){
			scr.add(blockCode.get(count));
			count++;
		}
		scr.add("	ScratchExtensions.register(ExtName, descriptor, ext);");
		scr.add("})({});");
		System.out.println("BuildScripts :: Success!");
		return scr;
	}
}
