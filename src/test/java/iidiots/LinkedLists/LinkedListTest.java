package iidiots.LinkedLists;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test 
    public void Constructor(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1, 2, 3);

        // Checking if the LinkedList put values in the right order
        assertAll(
                () -> assertEquals(1, TestList.get(0)),
                () -> assertEquals(2, TestList.get(1)),
                () -> assertEquals(3, TestList.get(2)));
    }
    
    @Test
    public void getIndex(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1, 2, 3);
        assertEquals(3, TestList.get(2));
    }
    
     @Test
     public void getIndexOutOfBounds(){
         LinkedList<Integer> TestList = new LinkedList<Integer>(1, 2, 3);
         assertThrows(IndexOutOfBoundsException.class, ()->TestList.get(10));
     }
    
    @Test
    public void addHead(){
        LinkedList<Integer> TestList = new LinkedList<Integer>();
        
        assertEquals(0, TestList.getSize());

        TestList.addHead(1);

        assertAll(
                () -> assertEquals(1, TestList.getHead()),
                () -> assertEquals(1, TestList.getSize())
        );
    }

    @Test
    public void addTail(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1, 2, 3);
        
        assertEquals(3, TestList.getSize());

        TestList.addTail(4);

        assertAll(
                () -> assertEquals(4, TestList.getTail()),
                () -> assertEquals(4, TestList.getSize())
        );
    }
    
    @Test
    public void add(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1, /* 2, */ 3);
        
        assertEquals(2, TestList.getSize());

        TestList.add(2, 1);

        assertAll(
                () -> assertEquals(2, TestList.get(1)),
                () -> assertEquals(3, TestList.getSize())
        );
    }

    @Test
    public void removeHead(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1000, 1, 2, 3);

        assertEquals(4, TestList.getSize());

        TestList.removeHead();

        assertAll(
                () -> assertEquals(1, TestList.getHead()),
                () -> assertEquals(3, TestList.getSize())
        );
    }

    @Test
    public void removeTail(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1, 2, 3, 1000);
        
        assertEquals(4, TestList.getSize());

        TestList.removeTail();

        assertEquals(3, TestList.getSize());
    }

    @Test
    public void remove(){
        LinkedList<Integer> TestList = new LinkedList<Integer>(1, 1000, 2, 3);

        assertEquals(4, TestList.getSize());

        TestList.remove(1);

        assertAll(
                () -> assertEquals(3, TestList.getSize()),
                () -> assertEquals(2, TestList.get(1))
        );
    }

    @Test
    public void equal(){
        LinkedList<Integer> TestList1 = new LinkedList<Integer>(1, 2, 3);
        LinkedList<Integer> TestList2 = new LinkedList<Integer>(1, 2, 3);

        assertTrue(TestList1.equals(TestList2));
    }
}
