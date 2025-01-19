import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to write a list of words to a file.
 */
public class MyFileWriter {
    
    /**
     * Name of file being written to.
     */
    private String filename;
    
    /**
     * Creates MyFileWriter with given filename to write to.
     * @param filename to write to
     */
    public MyFileWriter(String filename) {
        this.filename = filename;
    }
    
    /**
     * Opens the file specified by filename and writes each word in the given list of words to the file.
     * Each word is written to a new line in the file.
     *
     * @param list of words to write to the file
     */
    public void writeToFile(ArrayList<String> words) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
