package uc.za.uj.tgchipoyera.linkedlist.LinkedLists;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public void GetElement(){
        Node<String> TestNode = new Node<String>("test node");
        
        assertEquals(TestNode.getElement(), "test node");
    }
    
    @Test 
    public void GetNext(){
        Node<String> NextNode = new Node<String>("next node", null);
        Node<String> TestNode = new Node<String>("test node", NextNode);

        assertEquals(TestNode.getNext(), NextNode);
    }
    
    @Test
    public void SetNext(){
        Node<String> NextNode = new Node<String>("next node", null);
        
        Node<String> TestNode = new Node<String>("test node");
        TestNode.setNext(NextNode);

        assertEquals(TestNode.getNext(), NextNode);
        
    }

    @Test
    public void equals(){
        Node<String> TestNode1 = new Node<String>("next node");
        Node<String> TestNode2 = new Node<String>("next node");

        assertTrue(TestNode1.equals(TestNode2));
    }
}
