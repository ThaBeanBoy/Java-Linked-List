package uc.za.uj.tgchipoyera.linkedlist.LinkedLists;

/**
 * LinkedList
 * @param <E> The type stored in the linked list
 */
public class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /**
     * Constructs LinkedList object
     * @param Elements Default values to insert in the LinkedList
     */
    public LinkedList(E... Elements){ 
        for(int i = Elements.length - 1; i >= 0; i--) this.addHead(Elements[i]);
    }

    // GETTERS

    /**
     * Gets the size of the LinkedList
     * @return size
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Gets the element inside the head node of the LinkedList
     * @return Node
     */
    public E getHead(){
        if(this.isEmpty()) return null;

        return this.head.getElement();
    }

    /**
     * Gets the element inside the tail node of the LinkedList
     * @return Element
     */
    public E getTail(){
        if(this.isEmpty()) return null;

        return this.tail.getElement();
    }

    /**
     * Gets the element inside node located at the index specified
     * @param index index of node
     * @return the element inside the node
     * @throws IndexOutOfBoundsException if the index is outside the bounds of the LinkedList
     */
    public E get(int index) throws IndexOutOfBoundsException{
        return this.getNode(index).getElement();
    }

    // ADDERS

    /**
     * Adds new head node in the LinkedList
     * @param element the element to place inside the head node.
     * @return The current LinkedList
     */
    public LinkedList<E> addHead(E element){
        this.head = new Node<E>(element, this.head);

        if(this.isEmpty()) this.tail = this.head;

        this.size++;

        return this;
    }

    /**
     * Adds element to the LinkedList at the specified index
     * @param element the element to be stored in the LinkedList
     * @param index the index to place the element
     * @return The current LinkedList
     * @throws IndexOutOfBoundsException if the index is outside the bounds of the LinkedList
     */
    public LinkedList<E> add(E element, int index) throws IndexOutOfBoundsException {
        if(this.isEmpty() || index == 0) return this.addHead(element);

        else if(index > this.size - 1) throw new IndexOutOfBoundsException();

        else if(index == this.size-1) return this.addTail(element);

        else{
            Node<E> before = this.getNode(index-1);
    
            Node<E> newNode = new Node<E>(element, before.getNext());
    
            before.setNext(newNode);
            
            this.size++;

            return this;
        }
    }

    /**
     * Adds new tail node in the LinkedList
     * @param element the element at the tail
     * @return The current LinkedList
     */
    public LinkedList<E> addTail(E element){
        Node<E> newNode = new Node<E>(element, null);

        if(this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;

        this.size++;

        return this;
    }

    // REMOVERS

    /**
     * Removes the head and sets the node after the head as the new head
     * @return The current LinkedList
     */
    public LinkedList<E> removeHead(){
        if(this.isEmpty()) return this;

        this.head = this.head.getNext();

        this.size--;

        if(this.isEmpty()){
            this.tail = null;
        }

        return this;
    }

    /**
     * Removes the tail and sets the node before the tail as the new tail
     * @return The current LinkedList
     */
    public LinkedList<E> removeTail(){
        if(isEmpty()) return this;

        else if(this.size == 1) return this.removeHead();
        
        else {
            Node<E> answerNode = this.tail;
            
            Node<E> beforeTail = this.head;
    
            while(beforeTail.getNext().getNext() != null) beforeTail = beforeTail.getNext();
        
            beforeTail.setNext(null);

            this.tail = beforeTail;
            
            this.size--;

            return this;
        }
    }

    /**
     * Removes the element at the specified index
     * @param index the index
     * @return The current LinkedList
     */
    public LinkedList<E> remove(int index){
        if(this.isEmpty() || index == 0) return this.removeHead();

        else if(index > this.size - 1) throw new IndexOutOfBoundsException();

        else if(index == this.size-1) return this.removeTail();

        else{
            Node<E> before = this.getNode(index-1);

            before.setNext(before.getNext().getNext());
            
            this.size--;

            return this;
        }
    }

    // UTILITIES

    /**
     * Gets whether the LinkedList is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Gets the node at the specified index
     * @param index
     * @return The node at the index
     * @throws IndexOutOfBoundsException if the index is outside the bounds of the LinkedList
     */
    private Node<E> getNode(int index) throws IndexOutOfBoundsException{
        if(isEmpty()) return null;

        if(index > this.size || index < 0) throw new IndexOutOfBoundsException();
        
        Node<E> answer = this.head; 
        
        for(int i=0; i<index; i++) answer = answer.getNext();

        return answer;
    }
}
