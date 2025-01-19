import java.util.*;

public class InfoProcessor {

    private ArrayList<String> lines;

    // Costruttore senza argomenti
    public InfoProcessor() {
        this.lines = new ArrayList<>();
    }

    // Nuovo costruttore che accetta un ArrayList<String>
    public InfoProcessor(ArrayList<String> lines) {
        this.lines = lines;
    }

    public String getCourseName() {
        return getNextStringStartsWith("Course:");
    }

    public int getCourseId() {
        String idString = getNextStringStartsWith("CourseID:");
        return idString != null ? Integer.parseInt(idString) : 0;
    }

    public int getStudentId() {
        String idString = getNextStringStartsWith("StudentID:");
        return idString != null ? Integer.parseInt(idString) : 0;
    }

    String getNextStringStartsWith(String str) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(str)) {
                if (i + 1 < lines.size()) {
                    return lines.get(i + 1).trim();
                }
            }
        }
        return null;
    }
}