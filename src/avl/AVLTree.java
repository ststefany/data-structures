package avl;

public class AVLTree<T extends Comparable> {
    private final static int POS_IMBALANCE = 2;
    private final static int NEG_IMBALANCE = -2;
    private Node<T> root;

    public AVLTree() {
        root = null;
    }


    public Node<T> put(T element) {
        if (element == null) {
            throw new IllegalArgumentException("AVLTree cannot store null data");
        }

        if (root == null) {
            root = new Node<>(element);
            return root;
        }

        if (isThere(element)) {
            throw new IllegalArgumentException("Tree already has element " + element);
        }

        return add(root, element);
    }


    private Node<T> add(Node<T> current, T element) {
        int cmp = current.getElement().compareTo(element);
        Node<T> newNode = null;

        if (cmp > 0) {
            if (current.getLeft() != null) {
                current = current.getLeft();
                add(current, element);
            } else {
                newNode = new Node<>(element);
                current.setLeft(newNode);
            }
        }
        if (cmp < 0) {
            if (current.getRight() != null) {
                current = current.getRight();
                add(current, element);
            } else {
                newNode = new Node<>(element);
                current.setRight(newNode);
            }
        }
        recountHeight(current);
        balance(current);

        return newNode;
    }


    public void remove(T element) {

        if (this.isEmpty()) {
            System.err.println("Tree is already empty");
            return;
        }

        Node<T> toBeDeleted = find(element);

        if (toBeDeleted == null) {
            throw new IllegalArgumentException("There is no " + element + " in the tree");
        }

        root = removeInternal(root, element);
    }


    private Node<T> removeInternal(Node<T> current, T element) {

        if (current == null) return current;

        int cmp = current.getElement().compareTo(element);

        if (cmp > 0) {
            current.setLeft(removeInternal(current.getLeft(), element));
        } else if (cmp < 0)
            current.setRight(removeInternal(current.getRight(), element));
        else if (current.getLeft() != null && current.getRight() != null) {
            current.setElement((findMin(current.getRight())).getElement());
            current.setRight(removeInternal(current.getRight(), current.getElement()));
        } else
            current = (current.getLeft() != null) ? current.getLeft() : current.getRight();
        return balance(current);
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public String print(Node node, StringBuilder builder) {

        if (node != null) {
            print(node.getLeft(), builder);
            builder.append(node.getElement());
            builder.append(", ");
            print(node.getRight(), builder);
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        print(root, builder);
        builder.append("}");
        return builder.toString().replace(", }", "}");
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> findMin(Node<T> node) {
        if (node == null) {
            return node;
        }

        if ((node.getLeft()) != null) {
            findMin(node.getLeft());
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> x) {
        Node<T> newX = x.getRight();
        x.setRight(newX.getLeft());
        newX.setLeft(x);

        if (x == root) {
            root = newX;
        }

        return newX;
    }


    private Node<T> rotateLeft(Node<T> x) {
        Node<T> newX = x.getLeft();
        x.setLeft(newX.getRight());
        newX.setRight(x);

        if (x == root) {
            root = newX;
        }
        return newX;
    }

    private Node<T> balance(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (node.balanceFactor() == POS_IMBALANCE) {
            if (node.getRight().balanceFactor() < 0) {
                node.setLeft(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        if (node.balanceFactor() == NEG_IMBALANCE) {
            if (node.getLeft().balanceFactor() > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        return node;
    }


    private Node<T> find(T element) {
        Node<T> current = root;
        while (current != null) {
            if (element.compareTo(current.getElement()) > 0) {
                current = current.getRight();
                continue;
            }
            if (element.compareTo(current.getElement()) < 0) {
                current = current.getLeft();
                continue;
            }
            return current;
        }
        return null;
    }

    private boolean isThere(T element) {
        return find(element) != null;
    }

    private int getHeight(Node<T> node) {
        return node == null ? -1 : node.getHeight();
    }

    private void recountHeight(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException();
        }

        int left = getHeight(node.getLeft());
        int right = getHeight(node.getRight());

        node.setHeight(Math.max(left, right) + 1);
    }


}
