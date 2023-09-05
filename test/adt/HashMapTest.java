package adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
* @Author: Wong Fu Lim
* To run the test, you have to installed junit5.jar in your project.
* More info: https://www.jetbrains.com/help/idea/junit.html#intellij
*
* */

class HashMapTest {
    private HashMap<Integer, String> hashMap;

    @BeforeEach
    public void setUp() {
        // Create a new HashMap before each test
        hashMap = new HashMap<>();
    }

    @Test
    public void testDoubleSizeWorkForDefaultValue() {
        //Default capacity is 20
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, "value" + i);
        }
        assertDoesNotThrow(() -> hashMap.put(20, "value20"));
    }

    @Test
    public void testDoubleSizeWorkForCustomValue() {
        hashMap = new HashMap<>(10);
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, "value" + i);
        }
        assertDoesNotThrow(() -> hashMap.put(10, "value10"));
    }

    @Test
    public void testAfterRehashTheValueStillValid(){
        hashMap = new HashMap<>(10);
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, "value" + i);
        }

        hashMap.put(10, "value10");


        for(int i = 0; i <= 10; i++){
            assertEquals("value" + i, hashMap.get(i));
        }
    }

    @Test
    public void testPutNullKey() {
        assertThrows(IllegalArgumentException.class, () -> hashMap.put(null, "value"));
    }

    @Test
    public void testPutNullValue() {
        assertThrows(IllegalArgumentException.class, () -> hashMap.put(1, null));
    }

    @Test
    public void testGetNullKey(){
        assertThrows(IllegalArgumentException.class, () -> hashMap.get(null));
    }

    @Test
    public void testRemoveNullKey(){
        assertThrows(IllegalArgumentException.class, () -> hashMap.remove(null));
    }

    @Test
    public void testPutAndGet() {
        hashMap.put(1, "value1");
        hashMap.put(2, "value2");

        assertEquals("value1", hashMap.get(1));
        assertEquals("value2", hashMap.get(2));
    }

    @Test
    public void testPutForUpdateValue() {
        hashMap.put(1, "value1");
        hashMap.put(1, "value2");

        assertEquals("value2", hashMap.get(1));
    }

    @Test
    public void testPutAndRemoveAndGet() {
        hashMap.put(1, "value1");
        hashMap.put(2, "value2");

        hashMap.remove(1);
        assertNull(hashMap.get(1));
        assertEquals("value2", hashMap.get(2));
    }

    @Test
    public void testRemove() {
        hashMap.put(1, "value1");

        String removedValue = hashMap.remove(1);
        assertNull(hashMap.get(1));
        assertEquals("value1", removedValue);
    }

    @Test
    public void testKeys() {
        hashMap.put(1, "value1");
        hashMap.put(2, "value2");

        assertEquals(2, hashMap.keys().size());
        assertTrue(hashMap.keys().contains(1));
        assertTrue(hashMap.keys().contains(2));
    }

    @Test
    public void testValues() {
        hashMap.put(1, "value1");
        hashMap.put(2, "value2");

        assertEquals(2, hashMap.values().size());
        assertTrue(hashMap.values().contains("value1"));
        assertTrue(hashMap.values().contains("value2"));
    }

    @Test
    public void testContainsKey() {
        hashMap.put(1, "value1");

        assertTrue(hashMap.containsKey(1));
        assertFalse(hashMap.containsKey(2));
    }

    @Test
    public void testContainsValue() {
        hashMap.put(1, "value1");

        assertTrue(hashMap.containsValue("value1"));
        assertFalse(hashMap.containsValue("value2"));
    }

    @Test
    public void testSize() {
        assertEquals(0, hashMap.size());

        hashMap.put(1, "value1");
        assertEquals(1, hashMap.size());

        hashMap.put(2, "value1");
        assertEquals(2, hashMap.size());
    }

    @Test
    public void testSizeForPutUpdate(){
        hashMap.put(1, "value1");
        assertEquals(1, hashMap.size());

        hashMap.put(1, "value2");
        assertEquals(1, hashMap.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(hashMap.isEmpty());

        hashMap.put(1, "value1");
        assertFalse(hashMap.isEmpty());
    }

    @Test
    public void testIsFull() {
        for(int i = 0; i < 20; i++){
            hashMap.put(i, "value" + i);
        }

        //always return false, because the size will double when over the load factor
        assertFalse(hashMap.isFull());
    }

    @Test
    public void testClear() {
        hashMap.put(1, "value1");
        hashMap.put(2, "value2");

        hashMap.clear();

        assertTrue(hashMap.isEmpty());
        assertNull(hashMap.get(1));
        assertNull(hashMap.get(2));
    }

    @Test
    public void testCollision() {
        assertTrue(hashMap.getIndexForTestingClass(1,0) == hashMap.getIndexForTestingClass(21,0));
        //both keys index is 1
        hashMap.put(1, "value1");
        hashMap.put(21, "value2");

        //collision works since keys 21 does not replace key 1
        assertEquals("value1", hashMap.get(1));
        assertEquals("value2", hashMap.get(21));
    }

    @Test
    public void testNegativeKey(){
        hashMap.put(-101, "value1");
        assertEquals("value1", hashMap.get(-101));
    }

    @Test
    public void testNegativeKeyCollision(){
        assertTrue(hashMap.getIndexForTestingClass(-101,0) == hashMap.getIndexForTestingClass(-81,0));
        hashMap.put(-101, "value1");
        hashMap.put(-81, "value2");

        assertEquals("value1", hashMap.get(-101));
        assertEquals("value2", hashMap.get(-81));
    }

}