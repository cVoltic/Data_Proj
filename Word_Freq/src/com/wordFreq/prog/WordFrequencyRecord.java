package com.wordFreq.prog;
import java.util.*;

public class WordFrequencyRecord {

	public static void main(String[] args) {
		//Declaration of word counter object
		WordCount wordFreq = new WordCount();
		
		//Declare a document reader object
		DocReader docReader = new DocReader();
		
		//Declare a list of Map object 
		ArrayList< Map<String, Integer> > bookList = wordFreq.getBook();
	
		//Create a scanner object to get user input
		Scanner scan = wordFreq.getScanner();
		
		
		//Ask the user for an input of a
		//path to and the document name of the
		//list of all documents to read from
		System.out.println("Enter the path_to/document_list: "); 
		String docPath = scan.nextLine();	//document_list.txt						
		
		//Read from document path and store each document in an array list
		ArrayList<String> wordDoc = new ArrayList<String>();
		wordDoc = docReader.getDocument(docPath);
				
		
		//Ask the user to input a list of the common english words to track
		System.out.println("\nEnter the path_to/english_words_common.txt: ");
		String wordPath = scan.nextLine();
		
		///Read from list of world and store the list of words into an array list
		ArrayList<String> wordList = new ArrayList<String>();
		wordList = docReader.getDocument(wordPath);
			
		
		//read each file from get list of all document
		for (int i = 0; i < wordDoc.size(); i++) {
			//Open each document in the document list
			String docNamePath = wordDoc.get(i);
			ArrayList<String> doc = new ArrayList<String>();
			doc = docReader.getDocument(docNamePath);
			
			//Initialized a map to store word count in this file
			Map <String, Integer> wordMap = new TreeMap <String, Integer>();
			
			//check the frequency of input words against list of English words
			int value = 0;
			for (int m = 0; m < wordList.size(); m++) { 	
				wordMap.put(wordList.get(m), value);
			}
			
			//read each line of the sentence and split it into words
			for (int j = 0; j < doc.size(); j++) {
				//Split each words in a line
				String sentence = doc.get(j);
				
				//remove all punctuation
				sentence = sentence.replaceAll("\\p{Punct}", "");
				String[] inputWord = sentence.split(" ");
				
				//check the frequency of input words against list of English words
				for (int k = 0; k < wordList.size(); k++) {	
					//reset the counter for each word at the start of each sentence
					int count = 0;
					//Compare each word in a line
					for (int l = 0; l < inputWord.length; l++) {
						boolean match = wordFreq.wordMatch(wordList.get(k).toLowerCase(), inputWord[l].toLowerCase());
						if (match==true) {
							count += 1;
							value += count;
							wordMap.put(wordList.get(k), value);
						}					
					}
				}
			}
			//Compile the finding into a list
			bookList.add(wordMap);
		}
		
		//User input block for returned values after word counter
		while (true) {			
			//User prompt for get data from list
			System.out.println("\n\nChoose from list index option to display word count from txt: "
							+ "\n0: raven.txt"
							+ "\n1: frankenstein.txt"
							+ "\n2: dracula.txt");
			wordFreq.setIndex(scan.nextLine());
			
			
			//User prompt to choose a word from a list of available words
			System.out.println("\n\nChoose a word from english_words_common: ");
			wordFreq.setReferenceWord(scan.nextLine());	
			
			//Invoke getWord method
			String wordFrequency = wordFreq.getWord();
			System.out.println(wordFrequency);
			
			System.out.println("\nDo you wish to continue? Y/N");
			String choice = scan.nextLine();
			if (choice.equals("N") || choice.equals("n") || choice.equals("No") || choice.equals("no")) {
				break;
			}
		}
	}

}
