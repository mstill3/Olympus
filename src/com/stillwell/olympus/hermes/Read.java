package com.stillwell.olympus.hermes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//import com.stillwell.athena.Data;

public class Read 
{

	private static ArrayList<String> namesAndLevel = new ArrayList<String>();
	private static String line;
	private static String fileName;
	private static String sRegex;
	private static String ssRegex;
	private static String del;
	private static int location = 0;
	
	public Read(String setRegex /*,*/, String subsetRegex /*:*/){
		sRegex = setRegex;
		ssRegex = subsetRegex;
	}
	
	public void fromFile(String loc /*E:\\Matt\\Home\\Games\\RedRun\\times.lnk*/){
		fileName = loc;
	}
	
	public void read()
	{

		String words;
		Scanner fileScan = null, urlScan;

		try {
			fileScan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		while(fileScan.hasNext())
		{
			words = fileScan.next();
			
			urlScan = new Scanner(words);
			
			while(urlScan.hasNext())
				line = urlScan.next();

		}
		
		breakUp();
		
	}
	
	
	private void breakUp()
	{
		for(int i = 0; i <= line.length(); i++){
			location = line.indexOf(sRegex);
			if(location > 0){
				namesAndLevel.add(line.substring(i, (location)));			//
				del = line.substring(i, (location+1));
				line = line.replaceFirst(del, "");      //First to get mult instances
				i = -1;
			}else{
				namesAndLevel.add(line);			//
				del = line;
				line = line.replaceFirst(del, "");
				i = 10;//end
			}
		}
	}
	
	public void addData(String name, int n)
	{
		line += name + ssRegex + n + sRegex;
	}
	
	public ArrayList<String> getNamesAndLevel()
	{		
		return namesAndLevel;
	}
	
	public void deleteElement(int index){
		namesAndLevel.remove(index);
	}
	
	public String getElement(int index){
		return namesAndLevel.get(index);
	}
	
	public int getLength()
	{		
		return namesAndLevel.size();
	}
	
	public void clearAll()
	{		
		namesAndLevel.clear();
	}
	
	public String toString()
	{
		return "----------------------------------\n" + namesAndLevel.toString() + "\n----------------------------------";
	}

}
