package com.wordFreq.prog;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class GetWordTest {
	//Declare a word counter object
	WordCount wordCounter = new WordCount();
	
	//declare a Doc Reader Object
	DocReader docReader = new DocReader();
	
	@Test
	void test() {
		
		//create test Maps and store it in a book list
		ArrayList< Map<String, Integer> > bookList = wordCounter.getBook();

		Map <String, Integer> Map1 = new TreeMap <String, Integer>();
		Map <String, Integer> Map2 = new TreeMap <String, Integer>();
		Map <String, Integer> Map3 = new TreeMap <String, Integer>();
		
		Map1.put("this", 10);
		Map1.put("long", 22);
		Map1.put("what", 32);
		
		Map2.put("this", 32);
		Map2.put("long", 11);
		Map2.put("what", 101);
		
		Map3.put("this", 62);
		Map3.put("long", 333);
		Map3.put("what", 1);
		
		bookList.add(Map1);
		bookList.add(Map2);
		bookList.add(Map3);
		
		//test indexes:
		String[] testIndex= {"0", "1", "1", "2", "0", "0", "2", "1", "2"};
		String[] testReferenceWord={"this","long","what","long","what","long","what","this","this"};
		
		//Read from test file
		ArrayList<String> wordDoc = new ArrayList<String>();
		wordDoc = docReader.getDocument("/Users/ktrinh/Desktop/Word_Frequency_Complete/Word_Freq/src/getWordTest.txt");
		
		//Get Word Count Test Cases
		for (int i = 0; i < 9; i++) {
			//Read line from getWordTest document
			String testOutStr = wordDoc.get(i);
			
			//get Index and referenceWord for getWord method
			wordCounter.setIndex(testIndex[i]);
			wordCounter.setReferenceWord(testReferenceWord[i]);
			
			//Commence Test
			String methodOutStr = wordCounter.getWord();
			System.out.println("\nTesting Case #" + i);
			System.out.println("Comparing: " + testOutStr + ", " + methodOutStr);
			assertEquals(methodOutStr, testOutStr);
		}
		
	}

}
