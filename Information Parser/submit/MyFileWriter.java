import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileWriter {
    private String filename;

    public MyFileWriter(String filename) {
        this.filename = filename;
    }

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