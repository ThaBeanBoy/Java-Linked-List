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

    public LinkedList<E> addHead(E element){
        this.head = new Node<E>(element, this.head);

        if(this.isEmpty()) this.tail = this.head;

        this.size++;

        return this;
    }

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

    // Removing node

    public LinkedList<E> removeHead(){
        if(this.isEmpty()) return this;

        this.head = this.head.getNext();

        this.size--;

        if(this.isEmpty()){
            this.tail = null;
        }

        return this;
    }

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
