/*This class was created by colinator27.
LIMITED SUPPORT! MENUS AND URL NOT FUNCTIONAL YET
This class is part of Scratch Extension Creator.*/

package build;

import java.util.ArrayList;

public class BuildBlocks {
	public static int blockCount = 0;
	public static ArrayList<String> blocks = new ArrayList<String>();
	public static ArrayList<String> output = new ArrayList<String>();
	public static ArrayList<String> code = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> blockCode = new ArrayList<ArrayList<String>>();
	
	public static void compileBlocks(String url){
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> beginVars = beginVars();
		ArrayList<String> endVars = endVars(url); //TO-DO: IMPLEMENT URLS
		System.out.println("BuildBlocks :: Variables initiated");
		data.add(beginVars.get(0));
		data.add(beginVars.get(1));
		//data.add(blocks);
		int bcount = 0;
		while(bcount < blockCount){
			data.add(blocks.get(bcount));
			bcount++;
		}
		
		System.out.println("BuildBlocks :: Block data added");
		data.add(endVars.get(0));
		data.add(endVars.get(1));
		data.add(endVars.get(2));
		data.add(endVars.get(3));
		data.add(endVars.get(4));
		int count = 0;
		while(count < blockCount){
			count++;
			data.add("	ext.secId"+count+" = function(ext,callback){");
			int count2 = 0;
			
			//if(count < blockCode.size()){
				while(count2 < blockCode.get(count-1).size()){
					data.add(blockCode.get(count-1).get(count2));
					System.out.println(blockCode.get(count-1).get(count2));
					count2++;
				}
			//}
			//blockCode.get(0).get(count2);
			System.out.println("BuildBlocks :: Block code injected.");
			data.add("		callback();"); //TO-DO: Implement return statements for reporters.
			data.add("	};");
		}
		//data.add("	ext.idOne = function(callback){");
		//data.add("		callback();");
		//data.add("	};");
		System.out.println("BuildBlocks :: Operation completed");
		//return data;
		output = data;
	}
	private static ArrayList<String> beginVars(){
		ArrayList<String> begvars = new ArrayList<String>();
		begvars.add("	var descriptor = {");
		begvars.add("	        blocks: [");
		return begvars;
	}
	private static ArrayList<String> endVars(String url){
		ArrayList<String> endvars = new ArrayList<String>();
		endvars.add("	        ],");
		endvars.add("			menus: {");
		//TO-DO: Add menu functionality.
		endvars.add("			},");
        endvars.add("	        url: '"+url+"'");
        endvars.add("	};");
		return endvars;
	}
	public static void buildBlock(String type, String text){
		blockCount++; //Although the variable is created for "-", everything still works. :P
		if(!(type=="-")){
			blocks.add("	            ['"+type+"', '"+text+"', 'secId"+blockCount+"'],");
		} else {
			blocks.add("	            [\"-\"],");
		}
	}
	public static void buildBlockWithDefInput(String type, String text, String defInput){
		blockCount++;
		blocks.add("	            ['"+type+"', '"+text+"', 'secId"+blockCount+"', '"+defInput+"'],");
	}
	
	public static void buildBlockCode(int op1, String arg0, String arg1){
		code = new ArrayList<String>();
		//Op1 = WAIT
		//Op2 = ??
		if(op1==0){
			code.add("		"+arg0);
			blockCodeAdd();
		}
		if(op1==1){
			code.add("		window.setTimeout(function() {");
			code.add("			callback();");
			code.add("		}, ext*1000);");
			blockCodeAdd();
		}
	}
	private static void blockCodeAdd(){
		blockCode.add(code);
		code = new ArrayList<String>();
	}
}
