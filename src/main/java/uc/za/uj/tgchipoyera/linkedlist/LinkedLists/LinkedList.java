package uc.za.uj.tgchipoyera.linkedlist.LinkedLists;

public class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList(E... Elements){ 
        for(int i = Elements.length - 1; i >= 0; i--) this.addHead(Elements[i]);
    }

    // getters
    public int getSize(){
        return this.size;
    }

    public E getHead(){
        if(this.isEmpty()) return null;

        return this.head.getElement();
    }

    public E getTail(){
        if(this.isEmpty()) return null;

        return this.tail.getElement();
    }

    public E get(int index) throws IndexOutOfBoundsException{
        return this.getNode(index).getElement();
    }

    // Adding node

    public void addHead(E element){
        this.head = new Node<E>(element, this.head);

        if(this.isEmpty()) this.tail = this.head;

        size++;
    }

    public void add(E element, int index) throws IndexOutOfBoundsException {
        if(this.isEmpty() || index == 0) this.addHead(element);

        else if(index > this.size - 1) throw new IndexOutOfBoundsException();

        else if(index == this.size-1) this.addTail(element);

        else{
            Node<E> before = this.getNode(index-1);
    
            Node<E> newNode = new Node<E>(element, before.getNext());
    
            before.setNext(newNode);
        }

        size++;
    } 

    public void addTail(E element){
        Node<E> newNode = new Node<E>(element, null);

        if(this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;

        size++;
    }

    // Removing node

    public E removeHead(){
        if(this.isEmpty()) return null;

        E answer = this.head.getElement();

        this.head = this.head.getNext();

        this.size--;

        if(this.isEmpty()){
            this.tail = null;
        }

        return answer;
    }

    public E removeTail(){
        if(isEmpty()) return null;

        else if(this.size == 1) return this.removeHead();
        
        else {
            Node<E> answerNode = this.tail;
            
            Node<E> beforeTail = this.head;
    
            while(beforeTail.getNext().getNext() != null) beforeTail = beforeTail.getNext();
        
            beforeTail.setNext(null);

            this.tail = beforeTail;
            
            this.size--;

            return answerNode.getElement();
        }
    }

    // utility function
    public boolean isEmpty(){
        return this.size == 0;
    }

    private Node<E> getNode(int index) throws IndexOutOfBoundsException{
        if(isEmpty()) return null;

        if(index > this.size || index < 0) throw new IndexOutOfBoundsException();
        
        Node<E> answer = this.head; 
        
        for(int i=0; i<index; i++) answer = answer.getNext();

        return answer;
    }
}