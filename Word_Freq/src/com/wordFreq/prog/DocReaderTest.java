package com.wordFreq.prog;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DocReaderTest {
	//Declare a document reader object
	DocReader docReader = new DocReader();
	
	
	@Test
	void test() {
		
		//given the input array list of words
		ArrayList<String> testList = new ArrayList<String>(); 
		testList.add("home");
		testList.add("work");
		testList.add("Java");
		testList.add("C++");
		testList.add("Python");
		testList.add("Test");
		testList.add("Selenium");
		
		//read an array of words by DocDreader
		ArrayList<String> wordDoc = new ArrayList<String>();
		wordDoc = docReader.getDocument("/Users/ktrinh/Desktop/Word_Frequency_Complete/Word_Freq/src/docReaderTestFile.txt");
		
		//sanity check
		System.out.println(testList + ", " + wordDoc);
		
		//run test case
		assertEquals(testList, wordDoc);
		//fail("Not yet implemented");
	}

}
