import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileReader {
    private String filename;

    public MyFileReader(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> getCleanContent() {
        ArrayList<String> cleanedLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    cleanedLines.add(trimmedLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cleanedLines;
    }
}