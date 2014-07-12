package com.szh.release;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Parser {
	public void parser() throws IOException{
		
		File file = new File("E:\\changelog.xml");
		File note = new File("e:\\releaseNote.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		FileWriter fw = new FileWriter(note);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(fw);
		String line=null;
		boolean isComments = false;
		
	    while((line=br.readLine())!=null) {
	    	System.out.println(line);
	    	System.out.println(line.length());
	    	System.out.println(isComments);
	    	if(line.contains("commit ")){
	    		bw.write(line);
	    		bw.write("\n");
	    	}
	    	else if(line.contains("author ")){
	    		bw.write(line);
	    		bw.write("\n");
	    	}
	    	else if(line.contains("committer ")){
	    		isComments = true;
	    	}
	    	else if(isComments == true){
	    		if(line.startsWith(":")){
	    			isComments = false;
	    		}
	    		else{
	    			bw.write(line);
	    			bw.write("\n");
	    		}
	    	
	    	}
	    
	    }
	    bw.flush();
	    bw.close();
	    br.close();
	    fw.close();
	    isr.close();
	    fis.close();
	 
	}
}
