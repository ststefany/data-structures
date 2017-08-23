package linkedlist;

class Node<T> {

    private T element;
    private Node previous;
    private Node next;

    Node(T element, Node<T> previous, Node<T> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public Node() {
    }


    T getElement() {
        return element;
    }

    Node getPrevious() {
        return previous;
    }

    Node getNext() {
        return next;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (element == null) return "previous" + previous + ", next " + next;
        return element.toString();
    }


}
