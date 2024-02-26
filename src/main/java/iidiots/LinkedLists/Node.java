package iidiots.LinkedLists;

/**
 * Node for a linked list
 * @param <E> The type to be stored in the Node
 */
public class Node<E> {
    private final E element;
    private Node<E> next;

    /**
     * Constructs Node object
     * @param element the element stored by the node
     * @param next the next node after this node
     */
    public Node(E element, Node<E> next){
        this.element = element;
        this.next = next;
    }

    /**
     * Constructs Node object with the next Node reference set to `null`
     * @param element the element stored by the node
     */
    public Node(E element){
        this.element = element;
        this.next = null;
    }

    /**
     * Gets the element stored in the Node
     * @return element
     */
    public E getElement(){
        return this.element;
    }

    /**
     * Gets the next Node object after this Node object
     * @return Node
     */
    public Node<E> getNext(){
        return this.next;
    }

    /**
     * Sets the next Node object
     * @param next Node object after this Node object
     */
    public void setNext(Node<E> next){
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        if(! (obj instanceof Node)) return false;

        if(this.getClass() != obj.getClass()) return false;

        Node other = (Node) obj;

        if(this.next == null && other.next != null) return false;

        if(this.next != null && other.next == null) return false;

        if(this.next != null && !this.next.getElement().equals(other.next.getElement())) return false;

        if(!this.element.equals(other.element)) return false;

        return true;
    }
}
