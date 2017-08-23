package linkedlist;

public class LinkedList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
    }

    public void add(T data) {
        if (data != null) {
            if (first == null) {
                first = new Node<>();
                first.setElement(data);
                first.setPrevious(first);
                first.setNext(first);
                last = first;
            } else {
                Node<T> newNode = new Node<>(data, last, first);
                last.setNext(newNode);
                last = newNode;
            }
            size++;
        } else {
            throw new IllegalArgumentException("Stored element value cannot be null");
        }
    }


    //Removes only the first occurrence of the element in the list
    public void remove(T element) {
        if (contains(element)) {
            ListIterator<T> iterator = new ListIterator<>(this);
            do {
                if (iterator.getCurrent().getElement().equals(element)) {
                    {
                        unlink(iterator.getCurrent());
                        size--;
                        break;
                    }
                }
            } while (iterator.hasNext());
        } else throw new IllegalArgumentException("No element \"" + element + "\" in the list");
    }


    public boolean contains(T data) {
        ListIterator<T> iterator = new ListIterator<>(this);

        do {
            if (iterator.next().equals(data)) {
                return true;
            }
        } while (iterator.hasNext());
        return false;
    }

    private Node unlink(Node<T> node) {
        if (size == 1) {
            size = 0;
            first = new Node<>();
            first.setNext(first);
            first.setPrevious(first);
            last = first;
            return null;
        }

        (node.getPrevious()).setNext(node.getNext());
        (node.getNext()).setPrevious(node.getPrevious());

        if (node.equals(first)) {
            first = node.getNext();
        }

        if (node.equals(last)) {
            last = node.getPrevious();
        }

        return null;
    }


    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        ListIterator<T> iterator = new ListIterator<>(this);

        do {
            builder.append(iterator.getCurrent());
            builder.append(" ");
            iterator.next();
        } while (iterator.hasNext());

        builder.append("}");
        return builder.toString();
    }
}
