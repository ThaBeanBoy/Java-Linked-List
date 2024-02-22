package uc.za.uj.tgchipoyera.linkedlist.LinkedLists;

public class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E element, Node<E> next){
        this.element = element;
        this.next = next;
    }

    public Node(E element){
        this.element = element;
        this.next = null;
    }

    public E getElement(){
        return this.element;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }
}
