import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStringTest {

	//declare custom string for testing
	CustomString myCustomString;

	@BeforeEach
	public void setUp() throws Exception {
		//initialize custom string for testing
		this.myCustomString = new CustomString();
	}

	@Test
	void testGetString() {
		//string should be null to start, before setting it
		assertNull(this.myCustomString.getString());
		
		this.myCustomString.setString("hello");
		assertEquals("hello", this.myCustomString.getString());
		
		// Additional test cases
		this.myCustomString.setString("");
		assertEquals("", this.myCustomString.getString());
		
		this.myCustomString.setString("12345");
		assertEquals("12345", this.myCustomString.getString());
		
		this.myCustomString.setString("Test@123!");
		assertEquals("Test@123!", this.myCustomString.getString());
	}
	
	@Test
	void testSetString() {
		//string should be null to start, before setting it
		assertNull(this.myCustomString.getString());
		
		this.myCustomString.setString("Good-bye!");
		assertEquals("Good-bye!", this.myCustomString.getString());
		
		// Additional test cases
		this.myCustomString.setString("");
		assertEquals("", this.myCustomString.getString());
		
		this.myCustomString.setString("Java Programming");
		assertEquals("Java Programming", this.myCustomString.getString());
		
		this.myCustomString.setString(null);
		assertNull(this.myCustomString.getString());
	}
	
	@Test
	void testRemove() {
		assertEquals("", this.myCustomString.remove(""));
		
		this.myCustomString.setString(null);
		assertEquals("", this.myCustomString.remove(""));
		
		this.myCustomString.setString("my lucky numbers are 6, 8, and 19.");
		assertEquals("my lucky numbes e 6, 8, nd 19.", this.myCustomString.remove("ra6"));
		
		// Additional test cases
		this.myCustomString.setString("Hello World!");
		assertEquals("Hllo World!", this.myCustomString.remove("e"));
		
		this.myCustomString.setString("Data Science 101");
		assertEquals("Dta Scinc 101", this.myCustomString.remove("aeiou"));
		
		this.myCustomString.setString("Numbers: 12345");
		assertEquals("Numbers: 12345", this.myCustomString.remove("xyz"));
	}

	@Test
	void testReverse() {
		assertEquals("", this.myCustomString.reverse(""));
		
		this.myCustomString.setString(null);
		assertEquals("", this.myCustomString.reverse(""));
		
		this.myCustomString.setString("abc, XYZ; 123.");
		assertEquals("aBC, xyz; 123.", this.myCustomString.reverse("bcdxyz@3210."));
		
		// Additional test cases
		this.myCustomString.setString("Hello World!");
		assertEquals("hELLo wORLd!", this.myCustomString.reverse("hld"));
		
		this.myCustomString.setString("Java123");
		assertEquals("jAVA123", this.myCustomString.reverse("javA"));
		
		this.myCustomString.setString("UPPER lower");
		assertEquals("upper LOWER", this.myCustomString.reverse("upperLOWER"));
	}

	@Test
	void testFilterLetters() {
		assertEquals("", this.myCustomString.filterLetters('E', false));
		
		this.myCustomString.setString(null);
		assertEquals("", this.myCustomString.filterLetters('E', false));
		
		// Additional test cases
		this.myCustomString.setString("Hello World!");
		assertEquals("llo orld!", this.myCustomString.filterLetters('h', false));
		
		this.myCustomString.setString("abcdefg");
		assertEquals("defg", this.myCustomString.filterLetters('c', false));
		
		this.myCustomString.setString("ABCDEFG");
		assertEquals("ABC", this.myCustomString.filterLetters('D', true));
	}

}
