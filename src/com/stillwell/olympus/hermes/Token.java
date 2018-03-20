package com.stillwell.olympus.hermes;

import java.util.ArrayList;

public class Token {

	static ArrayList<String> names = new ArrayList<String>();
	static ArrayList<Integer> levels = new ArrayList<Integer>();
	static ArrayList<String> subsection = new ArrayList<String>();
	static String[] subset;
	static String[] sets;
	static String sRegex, ssRegex; 
	static int index = 0;

public Token(String setRegex /*,*/, String subsetRegex /*:*/) {
	sRegex = setRegex;
	ssRegex = subsetRegex;
}

	public void tokens(String phrase /*Matt:6,Bill:3,Sam:8,*/){

		int element = 100;

		subset = new String[element];
		sets = new String[element];


		sets = phrase.split(sRegex);

		for(int i = 0; i < sets.length; i++){
			subset = sets[i].split(ssRegex);
			for(String s: subset)
				subsection.add(s);
		}

		for(int j = 0; j < subsection.size(); j++)
			if(j % 2 == 0){
		
				if(j == 0){
					names.add(subsection.get(j).substring(1, (subsection.get(j).length() - 1)));
				}else{
					names.add(subsection.get(j));
				}
				
			}else{
				try{
					levels.add(Integer.parseInt((subsection.get(j))));
				}catch(Exception e){
//					System.out.println("Technical difficulties");
				}
			}

		/////////////////////////////////////////
//		System.out.println("\n           Phrase: " + phrase);

//		System.out.println("");

//		for(int k = 0; k < sets.length; k++)
//			System.out.println("\n            Set " + "#" + (k+1) + ": " + sets[k]);

//		System.out.println("");

//		for(int l = 0; l < subsection.size(); l++)
//			System.out.println("\n             Subset " + "#" + (l+1) + ": " + subsection.get(l));

//		System.out.println("");

//		for(int m = 0; m < names.size(); m++)
//			System.out.println("\n              Name " + "#" + (m+1) + ": " + names.get(m));

//		System.out.println("");

//		for(int n = 0; n < levels.size(); n++)
//			System.out.println("\n               Level " + "#" + (n+1) + ": " + levels.get(n));

		/////////////////////////////////////////
	}

	public String getToken(int i){
		return subset[i];
	}
	
	public String getName(int i){
		return names.get(i);
	}
	
	public int getLevel(int i){
		return levels.get(i);
	}

	public String[] getTopTen(){

		//		int[] temp = new int[10];
		//
		//		int max = 0;

		//		for(int n = 0; n < levels.size(); n++){
		//			//		System.out.println("Level " + "#" + (n+1) + ": " + levels.get(n));
		//			if(levels.get(n) > 0){
		//				max = levels;
		//			}
		//		}

		sortDecreasing();

		String[] temp = new String[10];


		//		for(int i = 0; i < temp.length; i++){
		//					names.get(i).replace('[', ' ');
		//					names.get(i).replace(']', ' ');
		//		}

		//		names.set(0, names.get(0).substring(1, names.get(0).length()));  //   [
		//		names.set(names.size()-1, names.get(names.size()-1).substring(0, names.size()-1));   //    ]

		for(int i = 0; i < 10; i++){
			
			try {
				temp[i] = names.get(i) + ssRegex + levels.get(i);
			} catch (Exception e) {
				System.out.println("a");
			}
			
			
		}

		return temp;

	}

	//-------------------------------------------------------
	//sorts the list in decreasing order
	//-------------------------------------------------------
	public void sortDecreasing()
	{
		int maxIndex;
		for (int i=0; i < levels.size()-1; i++)
		{
			//find largest element in list starting at location i
			maxIndex = i;
			for (int j = i+1; j < levels.size(); j++)
				if (levels.get(j) > levels.get(maxIndex))
					maxIndex = j;

			//swap list[i] with largest element
			int temp = levels.get(i);
			String temp2 = names.get(i);
			levels.set(i, levels.get(maxIndex));
			names.set(i, names.get(maxIndex));
			levels.set(maxIndex, temp);
			names.set(maxIndex, temp2);
		}
	}
	
	//-------------------------------------------------------
	//clears the list in decreasing order
	//-------------------------------------------------------
	public void clearAll()
	{
names.clear();
levels.clear();
subsection.clear();
index = 0;

for(int i = 0;i <= subset.length-1; i++){
	subset[i] = null;
}

for(int i = 0;i <= sets.length-1; i++){
	sets[i] = null;
}


	}
}
