import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCounterTest {

	MyFileReader fr1;
	MyFileReader fr2;
			
	@BeforeEach
	void setUp() throws Exception {
	
		// original war_and_peace.txt file
		fr1 = new MyFileReader("war_and_peace.txt");
				
		// test file containing some text from war_and_peace.txt, with different characters and info
		fr2 = new MyFileReader("test1.txt");
	}
	
	@Test
	void testWordCounter() {
		
		// Get clean lines from test1.txt
		ArrayList<String> linesSol = fr2.getCleanContent();
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(linesSol);
		
		// Get map of words and counts 
		Map<String, Integer> counters = wc.getWordCounter();

		// Test the count of different words in map
		assertEquals(1, (int) counters.get("Gutenberg"));
		assertEquals(3, (int) counters.get("and"));
		
				
		// Get clean lines from war_and_peace.txt
		linesSol = fr1.getCleanContent();
		
		// Create new Word Counter
		wc = new WordCounter(linesSol);
		
		// Get map of words and counts 
		counters = wc.getWordCounter();

		// Test the count of different words in map
		int atCount = counters.get("at");
		System.out.println("atCount: " + atCount);
		assertTrue(atCount >= 3700 & atCount <= 4700);
		
		int inCount = counters.get("in");
		System.out.println("inCount: " + inCount);
		assertTrue(inCount >= 7700 & inCount <= 8700);
		
		assertEquals((int) counters.getOrDefault("adasdada", 0), 0);
		assertEquals((int) counters.getOrDefault(" ", 0), 0);
		
		// Additional assertions for edge cases
		// Check if the list contains the word "the" which is expected to occur more than 10000 times
		ArrayList<String> ls1 = wc.getWordsOccuringMoreThan(0);
		assertTrue(ls1.contains("the"));
		
		// Get words occurring more than 5000 times
		ArrayList<String> ls2 = wc.getWordsOccuringMoreThan(5000);
		System.out.println("ls2: " + ls2.size());
		assertTrue(ls2.size() >= 2 & ls2.size() <= 4);
		
		// Test with negative number to check behavior
		ArrayList<String> ls3 = wc.getWordsOccuringMoreThan(-1);
		System.out.println("ls3: " + ls3.size());
		assertTrue(ls3.size() > 0);
		
		// Ensure that words with extremely high occurrences (e.g., greater than 10000) return valid words
		ArrayList<String> ls4 = wc.getWordsOccuringMoreThan(15000);
		assertTrue(ls4.size() > 0);
		
		// Added additional assertions
		assertTrue(ls1.size() > 0);
		assertTrue(ls2.size() > 0);
	}
	
	@Test
	void testGetWordsOccuringMoreThan() {
		
		// Create new FileReader
		MyFileReader fr = new MyFileReader("war_and_peace.txt");
		
		// Get clean lines from the File
		ArrayList<String> linesSol = fr.getCleanContent();
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(linesSol);
		
		// Get words occurring more than 0 times
		ArrayList<String> ls1 = wc.getWordsOccuringMoreThan(0);
		System.out.println("ls1: " + ls1.size());
		assertTrue(ls1.size() >= 41400 & ls1.size() <= 42400);
		
		// Get words occurring more than 1000 times
		ArrayList<String> ls2 = wc.getWordsOccuringMoreThan(1000);
		System.out.println("ls2: " + ls2.size());
		assertTrue(ls2.size() >= 50 & ls2.size() <= 60);
		
		// Get words occurring more than 10000 times
		ArrayList<String> ls3 = wc.getWordsOccuringMoreThan(10000);
		System.out.println("ls3: " + ls3.size());
		assertTrue(ls3.size() >= 4 & ls3.size() <= 6);
		assertEquals(ls3.get(0), "a");
		assertEquals(ls3.get(1), "of");
		
		// Additional assertions
		// Check if the word "the" is in the list of words that appear more than 10000 times
		assertTrue(ls3.contains("the"));
		
		// Get words occurring more than 100000 times (testing extreme values)
		ArrayList<String> ls4 = wc.getWordsOccuringMoreThan(100000);
		assertTrue(ls4.isEmpty()); // No word should occur more than 100000 times.
		
		// Added additional assertions
		assertTrue(ls1.size() > 0);
		assertTrue(ls2.size() > 0);
	}
	
	@Test
	void testGenerateWordCounts() {
		// lines to count words
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("war and the");
		lines.add("war the peace peace");
		lines.add("the war the");
		
		Map<String, Integer> expectedCounts = new HashMap<String, Integer>();
		expectedCounts.put("war", 3);
		expectedCounts.put("and", 1);
		expectedCounts.put("the", 4);
		expectedCounts.put("peace", 2);
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(lines);
		
		// Get and test map of words and counts
		assertEquals(expectedCounts, wc.getWordCounter());
		
		// Additional test case for a different input
		lines.clear();
		lines.add("hello world");
		lines.add("hello everyone");
		lines.add("world peace");
		
		expectedCounts.clear();
		expectedCounts.put("hello", 2);
		expectedCounts.put("world", 2);
		expectedCounts.put("everyone", 1);
		expectedCounts.put("peace", 1);
		
		wc = new WordCounter(lines);
		assertEquals(expectedCounts, wc.getWordCounter());
		
		// Additional assertions
		assertEquals(4, wc.getWordCounter().size()); // Check if map has 4 entries
		assertTrue(wc.getWordCounter().containsKey("hello")); // Ensure "hello" is a key
		assertTrue(wc.getWordCounter().containsKey("peace")); // Ensure "peace" is a key
	}
}
