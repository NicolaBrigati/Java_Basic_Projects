import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyFileWriterTest {
	
	MyFileWriter myFileWriter1; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.myFileWriter1 = new MyFileWriter("output_test.txt");  // test output file
	}
	
	@Test
	public void testWriteToFile() {
		
		// Create an ArrayList<String> to store a list of words to write to the test file "output_test.txt"
		ArrayList<String> wordsToWrite = new ArrayList<String>();
		wordsToWrite.add("Hello");
		wordsToWrite.add("world");
		wordsToWrite.add("this");
		wordsToWrite.add("is");
		wordsToWrite.add("a");
		wordsToWrite.add("test");
		
		// Call writeToFile to write the list of words to the file
		myFileWriter1.writeToFile(wordsToWrite);
		
		// Call readWrittenFile to read the written file and compare its contents to the defined ArrayList of words
		ArrayList<String> actual = readWrittenFile("output_test.txt");
		assertEquals("The written content does not match the expected content", wordsToWrite, actual);
	}
	
	/**
	 * Helper method for reading in the written file to check its contents.
	 * @param writtenFilename 
	 * @return an ArrayList of the lines from the written file
	 */
	public ArrayList<String> readWrittenFile(String writtenFilename) {
		ArrayList<String> expectedLines = new ArrayList<String>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(writtenFilename));
			String line = file.readLine();
			while (line != null) {
				expectedLines.add(line);
				line = file.readLine();
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return expectedLines;
	}
}
