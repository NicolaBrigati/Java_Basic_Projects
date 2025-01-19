import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to read lines from a file.
 */
public class MyFileReader {

    /**
     * Name of file being read.
     */
    private String filename;

    /**
     * Creates MyFileReader with given filename to read.
     * @param filename to read
     */
    public MyFileReader(String filename) {
        this.filename = filename;
    }

    /**
     * Opens the file specified by filename and reads the text line by line.
     * Cleans up each line by trimming whitespace from the beginning and end of each line.
     * Adds each line to an ArrayList<String> which is returned from the method.
     * If a line is empty (does not contain any text), it's skipped and is not added to the ArrayList<String>.
     * 
     * @return list of lines with no empty spaces at the beginning or end of each line
     */
    public ArrayList<String> getCleanContent() {
        ArrayList<String> lines = new ArrayList<String>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String cleanedLine = line.trim();
                if (!cleanedLine.isEmpty()) {
                    lines.add(cleanedLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
