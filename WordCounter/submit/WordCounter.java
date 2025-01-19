import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Counts words in a given list of lines from a file.
 */
public class WordCounter {

    /**
     * List of lines of words to count.
     */
    private ArrayList<String> lines;
    
    /**
     * Map storing the count of each word in the list of lines.
     */
    private Map<String, Integer> wordCount;

    /**
     * Creates WordCounter based on the given list of lines.
     * Starts the process of generating the count of each word in the list.
     * @param lines of words to count
     */
    public WordCounter(ArrayList<String> lines) {
        this.lines = lines;
        this.wordCount = new HashMap<String, Integer>();
        this.generateWordCounts();
    }

    /**
     * Calculates the count of each word in the list of lines.
     * Traverses the list of lines, and keeps track of the count of each word.
     */
    private void generateWordCounts() {
        for (String line : lines) {
            String[] words = line.split("\\s+"); // Split by spaces
            for (String word : words) {
                word = word.trim();
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
    }
    
    /**
     * Gets the HashMap<String, Integer> wordCount.
     * @return wordCount
     */
    public Map<String, Integer> getWordCounter() {
        return this.wordCount;
    }

    /**
     * Gets a list of words that appear a particular number of times, indicated by the given threshold.
     * @param threshold (minimum word count) for words to include in the returned list.
     * @return list of words with a count >= threshold
     */
    public ArrayList<String> getWordsOccuringMoreThan(int threshold) {
        ArrayList<String> result = new ArrayList<String>();
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
