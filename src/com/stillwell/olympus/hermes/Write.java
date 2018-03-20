package com.stillwell.olympus.hermes;


import java.io.FileWriter;
import java.io.IOException;

public class Write {

	static String sRegex;
	
	public Write(String setRegex/*,*/) {
		sRegex = setRegex;
	}
	
	public void write(String currentSaveData/*Matt:6*/, String loc/*:\\Matt\\Home\\Games\\RedRun\\times.lnk*/) {
		
		try {
			String filename = loc;
			FileWriter names = new FileWriter(filename,true); //the true will append the new data
			names.write(currentSaveData + sRegex);//appends the string to the file
			names.close();
		} catch(IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
		
	}

	
}
