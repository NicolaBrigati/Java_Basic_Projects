import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntegerArrayListTest {
    CustomIntegerArrayList customList;

    @BeforeEach
    void setUp() {
        customList = new CustomIntegerArrayList();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        customList.add(4);
        customList.add(5);
    }

    @Test
    void testAddInt() {
        customList.add(6);
        assertEquals(6, customList.get(5));
    }

    @Test
    void testAddIntInt() {
        customList.add(2, 6);
        assertEquals(6, customList.get(2));
    }

    @Test
    void testRemoveInt() {
        customList.remove(2);
        assertEquals(4, customList.get(2));
    }

    @Test
    void testRemoveIntInt() {
        customList.remove(2, 3);  // Rimuovi 2 occorrenze di 3
        assertFalse(customList.getArrayList().contains(3));
    }

    @Test
    void testSpliceIntInt() {
        customList.splice(2, 2);  // Rimuovi 2 elementi a partire dall'indice 2
        assertEquals(3, customList.get(2));
    }

    @Test
    void testSpliceIntIntIntArray() {
        int[] newArray = {9, 8};
        customList.splice(2, 1, newArray);  // Rimuovi 1 elemento e inserisci {9, 8}
        assertArrayEquals(new int[] {1, 2, 9, 8, 4, 5}, customList.getArrayList().stream().mapToInt(i -> i).toArray());
    }

    @Test
    void testGet() {
        assertEquals(1, customList.get(0));
        assertEquals(2, customList.get(1));
    }

    @Test
    void testGetArrayList() {
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, customList.getArrayList().stream().mapToInt(i -> i).toArray());
    }
}
