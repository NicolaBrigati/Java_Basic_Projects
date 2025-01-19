import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InfoProcessorTest {
    
    ArrayList<String> lines1 = new ArrayList<String>();
    ArrayList<String> lines2 = new ArrayList<String>();
    ArrayList<String> lines4 = new ArrayList<String>();
    ArrayList<String> lines5 = new ArrayList<String>();
    
    InfoProcessor infoProcessor1 = new InfoProcessor(lines1);  // sample file
    InfoProcessor infoProcessor2 = new InfoProcessor(lines2);  // normal file
    InfoProcessor infoProcessor4 = new InfoProcessor(lines4);  // file with different info
    InfoProcessor infoProcessor5 = new InfoProcessor(lines5);  // another file with different info
    
    @BeforeEach
    void setUp() {
        // sample file
        this.lines1.add("hello");
        this.lines1.add("world");
        this.lines1.add("MCIT");
        
        // normal file
        this.lines2.add("Course:");
        this.lines2.add("CIT590");
        this.lines2.add("CourseID:");
        this.lines2.add("590");
        this.lines2.add("StudentID:");
        this.lines2.add("101");

        // file with different info
        this.lines4.add("Course:");
        this.lines4.add("CIT 593");
        this.lines4.add("CourseID:");
        this.lines4.add("593");
        this.lines4.add("StudentID:");
        this.lines4.add("59876");
        
        // another file with different info
        this.lines5.add("Course:");
        this.lines5.add("OMCIT 596");
        this.lines5.add("CourseID:");
        this.lines5.add("596");
        this.lines5.add("StudentID:");
        this.lines5.add("01");
    }
    
    @Test
    void testGetCourseName() {
        // Test normal file
        String actual = infoProcessor2.getCourseName();
        assertEquals("CIT590", actual);
        
        // Test file with different info
        String actual2 = infoProcessor4.getCourseName();
        assertEquals("CIT 593", actual2);
        
        // Test another file with different info
        String actual3 = infoProcessor5.getCourseName();
        assertEquals("OMCIT 596", actual3);
    }
    
    @Test
    void testGetCourseID() {
        // Test normal file
        int actual = infoProcessor2.getCourseId();
        assertEquals(590, actual);
        
        // Test file with different info
        int actual2 = infoProcessor4.getCourseId();
        assertEquals(593, actual2);
        
        // Test another file with different info
        int actual3 = infoProcessor5.getCourseId();
        assertEquals(596, actual3);
    }
    
    @Test
    void testGetStudentID() {
        // Test normal file
        int actual = infoProcessor2.getStudentId();
        assertEquals(101, actual);
        
        // Test file with different info
        int actual2 = infoProcessor4.getStudentId();
        assertEquals(59876, actual2);
        
        // Test another file with different info
        int actual3 = infoProcessor5.getStudentId();
        assertEquals(1, actual3);  // "01" should be treated as 1
    }
    
    @Test
    void testGetNextStringStartsWith() {
        // Basic functionality test - should return next string in the list
        String actual = infoProcessor1.getNextStringStartsWith("hello");
        assertEquals("world", actual);
        
        actual = infoProcessor1.getNextStringStartsWith("world");
        assertEquals("MCIT", actual);
        
        // Test for string that doesn't exist - should return null
        actual = infoProcessor1.getNextStringStartsWith("goodbye");
        assertEquals(null, actual);
        
        // Test for string that exists in another file
        String actual2 = infoProcessor4.getNextStringStartsWith("Course:");
        assertEquals("CIT 593", actual2);
        
        // Test for string that doesn't exist in another file
        String actual3 = infoProcessor4.getNextStringStartsWith("goodbye");
        assertEquals(null, actual3);
    }
}
