package com.wordFreq.prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DocReader {
	//Constructor
	public DocReader() {
		System.out.println("DocReader: Constructor Called\n");
	}
	
	//method to read a document
	public ArrayList<String> getDocument(String docPath) {
		//Read document_list.txt
		File docList = new File(docPath);
		//Sanity check
		System.out.println("\nFile exists: " + docList.exists());
		System.out.println("Opening File: " + docList);
		
		//Initialized array to store path of all files of interest
		ArrayList<String> wordDoc = new ArrayList<String>();
		
		//Reading from document_list.txt
		try (BufferedReader br = new BufferedReader(new FileReader(docList)) ) {
			//Read line from File
			String tempLine;
			while((tempLine = br.readLine()) != null) {
				wordDoc.add(tempLine);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return wordDoc;
	}
}
