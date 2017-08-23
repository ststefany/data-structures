package linkedlist;

class Node<T> {

    private T element;
    private Node<T> previous;
    private Node<T> next;

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

    public void setElement(T element) {
        this.element = element;
    }

    Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (element == null) return "previous" + previous + ", next " + next;
        return element.toString();
    }


}
