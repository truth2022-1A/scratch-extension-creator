/*This class was created by colinator27.
THIS IS THE MAIN CLASS.
This class is part of Scratch Extension Creator.*/

package main;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public static String blockData;
	public static boolean isChrome = false;
	
	public static void main (String[] args) {
		System.err.println("NOTE: This program is IN DEVELOPMENT, and may have BUGS and ISSUES.");
	
		System.err.println("WARN: LIMITED SUPPORT! SOME FEATURES MAY NOT FUNCTION CORRECTLY.");
		//System.err.println("WARN: LIMITED SUPPORT! BLOCK FUNCTIONS NOT ADDED YET.");
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
			ex.printStackTrace();
		}
		initJFrame();
		System.out.println("MainFrame :: JFrame init COMPLETE");
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void initJFrame(){
		JLabel label1 = new JLabel("Block Text:");
		JLabel label2 = new JLabel("Extension Title:");
		JLabel label3 = new JLabel("About Text URL:");
		JLabel label4 = new JLabel("Type of Block:");
		JLabel label5 = new JLabel("Default Input:");
		JLabel label6 = new JLabel("Custom JS Code:");
		JLabel label7 = new JLabel("Author Name:");
		JLabel label8 = new JLabel("Description:");
		
		String[] choice1 = {"Command Block","Reporter Block","Divider (space)","Waiting Block"};
	    JComboBox cb = new JComboBox();
	    for (int i = 0; i < 4;)
	        cb.addItem(choice1[i++]);
		//br1.setUI();
		JPanel mainPnl = new JPanel();
		JTextField aboutText = new JTextField(10);
		JTextField customCode = new JTextField(15);
		JTextField blockText = new JTextField(10);
		JTextField defInputText = new JTextField(8);
		JTextField extName = new JTextField(10);
		JTextField authName = new JTextField(10);
		JTextField descText = new JTextField(10);
		JCheckBox hasCustomCode = new JCheckBox("Custom Code?");
		JCheckBox isChromeExtension = new JCheckBox("Is Chrome Extension?");
		JCheckBox hasDefInput = new JCheckBox("Has Default Input?");
		JButton StartButton = new JButton("Add Block/Build!");
		StartButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(isChromeExtension.isSelected()){
		    		isChrome = true;
		    		JOptionPane.showMessageDialog(null,"To use the extension in Chrome, you must be in DEVELOPER MODE on the extensions page. \n"
		    										 + "Then, click \"Load unpacked extension...\" and set the folder to the folder created that's called \n"
		    										 + "\"Extension Build,\" which is located in the folder where this program's JAR file is.");
		    	} else {
		    		isChrome = false;
		    	}
		    	if(cb.getSelectedIndex()==0){
		    		if(!hasDefInput.isSelected()){
		    			build.BuildBlocks.buildBlock(" ", blockText.getText().replaceAll("'", "\\\\'"));
		    		} else {
		    			build.BuildBlocks.buildBlockWithDefInput(" ", blockText.getText().replaceAll("'", "\\\\'"),defInputText.getText().replaceAll("'", "\\\\'"));
		    		}
		    		//build.BuildBlocks.buildBlockCode(1,"","");
		    	} else if(cb.getSelectedIndex()==1){
		    		if(!hasDefInput.isSelected()){
		    			build.BuildBlocks.buildBlock("r", blockText.getText().replaceAll("'", "\\\\'"));
		    		} else {
		    			build.BuildBlocks.buildBlockWithDefInput("r", blockText.getText().replaceAll("'", "\\\\'"),defInputText.getText().replaceAll("'", "\\\\'"));
		    		}
		    	} else if(cb.getSelectedIndex()==2){
		    		build.BuildBlocks.buildBlock("-", "");
		    	} else if(cb.getSelectedIndex()==3){
		    		if(!hasDefInput.isSelected()){
		    			build.BuildBlocks.buildBlock("w", blockText.getText().replaceAll("'", "\\\\'"));
		    		} else {
		    			build.BuildBlocks.buildBlockWithDefInput("w", blockText.getText().replaceAll("'", "\\\\'"),defInputText.getText().replaceAll("'", "\\\\'"));
		    		}
		    	} else {
		    		System.err.println("MainFrame :: BLOCK NOT CREATED; NO CORRECT SELECTED INDEX.");
		    	}
		    	if(hasCustomCode.isSelected()){
		    		if(!(cb.getSelectedIndex()==2)){
		    			build.BuildBlocks.buildBlockCode(0, customCode.getText().replaceAll("'", "\\\\'"), "");
		    		} else {
		    			build.BuildBlocks.buildBlockCode(0, "", "");
		    		}
		    	} else {
		    		build.BuildBlocks.buildBlockCode(0, "", "");
		    	}
		    	try {
				    Thread.sleep(100);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
					ex.printStackTrace();
				}
		    	build.BuildBlocks.compileBlocks(aboutText.getText());
		    	try {
		    		if(isChrome){
		    			build.WriteAboutText.write(aboutText.getText());
		    		}
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
		    	try {
		    		if(isChrome){
		    			build.WriteManifestJson.write(extName.getText(), descText.getText(), authName.getText());
		    		}
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
		    	try {
		    		if(isChrome){
		    			build.WriteInjector.write();
		    		}
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
		    	try {
					build.WriteToScript.writeMainScript(build.BuildScripts.compileScript(build.BuildBlocks.output, extName.getText().replaceAll("'", "\\\\'")));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
		    	
		    	 
		    }
		});
		 cb.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	if(cb.getSelectedIndex()==2){
			    		blockText.setVisible(false);
			    		label1.setVisible(false);
			    		defInputText.setVisible(false);
					    label5.setVisible(false);
					    hasDefInput.setVisible(false);
					    
			    	} else {
			    		blockText.setVisible(true);
			    		label1.setVisible(true);
			    		if(hasDefInput.isSelected()){
			    			label5.setVisible(true);
			    			defInputText.setVisible(true);
			    		}
			    		hasDefInput.setVisible(true);
			    	}
			    }
			});
		 hasDefInput.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 if(hasDefInput.isSelected()){
					 defInputText.setVisible(true);
				     label5.setVisible(true);
				     JOptionPane.showMessageDialog(null,"To have a number input, in the block text section type \"%n\", otherwise, for text inputs, type \"%s\"");
				 } else {
					 defInputText.setVisible(false);
				     label5.setVisible(false);
				 }
			 }
		 });
		 hasCustomCode.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e){
				 if(hasCustomCode.isSelected()){
					 label6.setVisible(true);
					 customCode.setVisible(true);
					 JOptionPane.showMessageDialog(null,"Custom code is written in the language JavaScript. If you come across any errors, be sure to check your code.");
				 } else {
					 label6.setVisible(false);
					 customCode.setVisible(false);
				 }
			 }
		 });
		//pnlButton.setBounds(800, 800, 200, 100);
		//pnlButton.add(br2);
       //pnlButton.add(br1);
		mainPnl.add(label2);
	    mainPnl.add(extName, BorderLayout.SOUTH);
	    mainPnl.add(label7);
	    mainPnl.add(authName, BorderLayout.SOUTH);
	    mainPnl.add(label8);
	    mainPnl.add(descText, BorderLayout.SOUTH);
	    mainPnl.add(label1);
        mainPnl.add(blockText, BorderLayout.SOUTH);
        mainPnl.add(label5);
        mainPnl.add(defInputText);
        defInputText.setVisible(false);
        label5.setVisible(false);
        mainPnl.add(label6);
        mainPnl.add(customCode);
        label6.setVisible(false);
        customCode.setVisible(false);
        mainPnl.add(label3);
        mainPnl.add(aboutText, BorderLayout.SOUTH);
        mainPnl.add(label4);
        mainPnl.add(cb);
        mainPnl.add(hasCustomCode);
        mainPnl.add(hasDefInput);
        mainPnl.add(isChromeExtension);
        mainPnl.add(StartButton);
		
		JFrame frame = new JFrame();
		frame.setSize(960,540);
		frame.add(mainPnl);
		StartButton.setBounds(60, 400, 220, 30);
		frame.setTitle(Info.title()+" (v"+Info.versionNumber()+")");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
