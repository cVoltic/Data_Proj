package com.wordFreq.prog;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordCount implements Frequency {
	
	//Private Variables
	private ArrayList< Map<String, Integer> > bookList = new ArrayList< Map<String, Integer> >();
	private Scanner scan = new Scanner(System.in);
	private String index = "";
	private String referenceWord = "";
	
	//constructor
	public WordCount() {
		System.out.println("Word Counter: Constructor Called\n");
	}
	
	
	//getter methods
	public ArrayList< Map<String, Integer> > getBook() {
		return bookList;
	}	
	
	public Scanner getScanner() {
		return scan;
	}
	
	public String getIndex() {
		return index;
	}
	
	public String getReferenceWord() {
		return referenceWord;
	}
	
	
	//setter methods
	public String setIndex(String index) {
		this.index = index;
		return this.index; 
	}
	
	public String setReferenceWord(String referenceWord) {
		this.referenceWord = referenceWord;
		return this.referenceWord;
	}
	
	//Specialized methods
	//Method to check two words to see if they are equals
	public boolean wordMatch(String desireWord, String inputWord) {
		boolean statement = false;
		if (inputWord.toString().equals(desireWord.toString())) {
			statement = true; 
		}
		return statement;
	} 
	
	//Interface Methods
	@Override 
	public String getWord() {
		String myStr = "";
		
		//Get the index of the book of reference
		Map <String, Integer> displayMap = new TreeMap <String, Integer>();
		displayMap = (Map<String, Integer>)bookList.get(Integer.parseInt(index));
		
		//Check to see if the map contains the specified word
		if (displayMap.containsKey(referenceWord) == false) {
			myStr = "Invalid Input, word not found";
		} 
		else {
			//return set view
			Set< Map.Entry<String, Integer> > st = displayMap.entrySet();		
			//Check the map output
			for (Map.Entry<String, Integer> mapEntry:st) {
				if (mapEntry.getKey().equals(referenceWord)){
						myStr = (mapEntry.getKey()+" : "+mapEntry.getValue());
				}
			}
		}
		return myStr;
	}


}
