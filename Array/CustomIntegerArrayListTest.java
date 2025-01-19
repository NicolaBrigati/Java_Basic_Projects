import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayAndArrayListTest {

	// declare myArrayAndArrayList which is the object for testing
	ArrayAndArrayList myArrayAndArrayList;
	
	@BeforeEach
	void setUp() throws Exception {
		// initialize myArrayAndArrayList for testing
		this.myArrayAndArrayList = new ArrayAndArrayList();
	}
	
	/**
	 * Test howMany method in ArrayAndArrayList.
	 */
	@Test
	void testHowMany() {
		// element in the array
		int[] array = {1, 3, 5, 7, 9, 1, 2, 3, 4, 5};
		assertEquals(2, this.myArrayAndArrayList.howMany(array, 1));
		
		// Test with element that occurs more than once
		assertEquals(2, this.myArrayAndArrayList.howMany(array, 5));
		
		// Test with element that does not exist in the array
		assertEquals(0, this.myArrayAndArrayList.howMany(array, 10));
		
		// Test with an empty array
		int[] emptyArray = {};
		assertEquals(0, this.myArrayAndArrayList.howMany(emptyArray, 1));
	}
	
	/**
	 * Test findMax method in ArrayAndArrayList.
	 */
	@Test
	void testFindMax() {
		// findMax in a non-empty array
		int[] array = {1, 3, 5, 7, 9, 1, 2, 3, 4, 5};
		assertEquals(9, this.myArrayAndArrayList.findMax(array));
		
		// Test with all negative numbers
		int[] negativeArray = {-1, -3, -5, -7};
		assertEquals(-1, this.myArrayAndArrayList.findMax(negativeArray));
		
		// Test with an array of identical numbers
		int[] identicalArray = {4, 4, 4, 4};
		assertEquals(4, this.myArrayAndArrayList.findMax(identicalArray));
		
		// Test with an empty array
		int[] emptyArray = {};
		assertEquals(-1, this.myArrayAndArrayList.findMax(emptyArray));
	}

	/**
	 * Test maxArray method in ArrayAndArrayList.
	 */
	@Test
	void testMaxArray() {
		// test a valid array.
		int[] array = {1, 3, 5, 7, 9, 1, 2, 3, 4, 5};
		ArrayList<Integer> testArrayList = new ArrayList<Integer>();
		testArrayList.add(9);
		assertEquals(testArrayList, this.myArrayAndArrayList.maxArray(array));
		
		// Test with multiple occurrences of the max value
		int[] array2 = {2, 4, 8, 12, 12, 4};
		ArrayList<Integer> testArrayList2 = new ArrayList<Integer>();
		testArrayList2.add(12);
		testArrayList2.add(12);
		assertEquals(testArrayList2, this.myArrayAndArrayList.maxArray(array2));
		
		// Test with a single-element array
		int[] array3 = {5};
		ArrayList<Integer> testArrayList3 = new ArrayList<Integer>();
		testArrayList3.add(5);
		assertEquals(testArrayList3, this.myArrayAndArrayList.maxArray(array3));
		
		// Test with an empty array
		int[] emptyArray = {};
		assertNull(this.myArrayAndArrayList.maxArray(emptyArray));
	}

	/**
	 * Test swapZero method in ArrayAndArrayList.
	 */
	@Test
	void testSwapZero() {
		// test an array containing 0
		int[] array = {0, 1, 0, 2, 0, 3, 0, 5};
		int[] testArray = {1, 2, 3, 5, 0, 0, 0, 0};
		this.myArrayAndArrayList.swapZero(array);
		assertArrayEquals(testArray, array);
		
		// Test with no zeros in the array
		int[] array2 = {1, 2, 3, 4};
		int[] testArray2 = {1, 2, 3, 4};  // No change expected
		this.myArrayAndArrayList.swapZero(array2);
		assertArrayEquals(testArray2, array2);
		
		// Test with an array of all zeros
		int[] array3 = {0, 0, 0, 0};
		int[] testArray3 = {0, 0, 0, 0};  // No change expected
		this.myArrayAndArrayList.swapZero(array3);
		assertArrayEquals(testArray3, array3);
		
		// Test with an empty array
		int[] emptyArray = {};
		int[] testArray4 = {};  // No change expected
		this.myArrayAndArrayList.swapZero(emptyArray);
		assertArrayEquals(testArray4, emptyArray);
	}
}
