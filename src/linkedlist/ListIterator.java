package linkedlist;

public class ListIterator<T> {
    private LinkedList<T> list;
    private Node<T> current;

    public ListIterator(LinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Nothing to iterate through");
        }
        this.list = list;
        current = list.getFirst();
    }

    public T next() {
        T next = current.getElement();
        current = current.getNext();
        return next;

    }

    public boolean hasNext() {
        return current != list.getLast();
    }

    public Node<T> getCurrent() {
        return current;
    }
}
