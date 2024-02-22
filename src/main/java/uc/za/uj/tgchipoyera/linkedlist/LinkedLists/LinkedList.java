package uc.za.uj.tgchipoyera.linkedlist.LinkedLists;

public class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList(){ }

    // getters
    public int getSize(){
        return this.size;
    }

    public E first(){
        if(this.isEmpty()) return null;

        return this.head.getElement();
    }

    public E last(){
        if(this.isEmpty()) return null;

        return this.tail.getElement();
    }

    public E get(int index) throws IndexOutOfBoundsException{
        return this.getNode(index).getElement();
    }

    // Adding node

    public void addFirst(E element){
        this.head = new Node<E>(element, this.head);

        if(this.isEmpty()) this.tail = this.head;

        size++;
    }

    public void add(E element, int index){
        if(this.isEmpty() || index == 0) this.addFirst(element);

        else if(index == this.size-1) this.addLast(element);

        else{
            Node<E> before = this.getNode(index);
    
            Node<E> newNode = new Node<E>(element, before.getNext());
    
            before.setNext(newNode);
        }


        size++;
    }

    public void addLast(E element){
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

    public E removeFirst(){
        if(this.isEmpty()) return null;

        E answer = this.head.getElement();

        this.head = this.head.getNext();

        this.size--;

        if(this.isEmpty()){
            this.tail = null;
        }

        return answer;
    }

    // utility function
    public boolean isEmpty(){
        return this.size == 0;
    }

    private Node<E> getNode(int index) throws IndexOutOfBoundsException{
        if(isEmpty()) return null;

        if(index > this.size || index < 0) throw new IndexOutOfBoundsException();
        
        Node<E> answer = this.head; 
        
        for(int i=0; i<(index-1); i++) answer = answer.getNext();

        return answer;
    }
}
