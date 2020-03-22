package com.wordFreq.prog;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class WordMatchingTest {
	//declare a Word Count Object
	WordCount wordChecker = new WordCount();
	
	//declare a Doc Reader Object
	DocReader docReader = new DocReader();

	@Test
	void test() {
		
		//word matching test
		//Read from test file and store word1, word2, boolean
		ArrayList<String> wordDoc = new ArrayList<String>();
		wordDoc = docReader.getDocument("/Users/ktrinh/Desktop/Word_Frequency_Complete/Word_Freq/src/wordCheckerTestFile.txt");
		for (int i = 0; i < wordDoc.size(); i++) {
			//Read from test Word Check Test File
			String sentence = wordDoc.get(i);
			String[] word = sentence.split(" ");
			
			//Split sentences into words
			String inputWord = word[0];
			String desiredWord = word[1];
			Boolean expectedResult = Boolean.parseBoolean(word[2]);
			Boolean actualResult = wordChecker.wordMatch(desiredWord, inputWord);
			
			//Commence Test
			System.out.println("Testing Case #" + i);
			assertEquals(expectedResult, actualResult);
		}
		
	}

}
