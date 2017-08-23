package avl;

import com.sun.istack.internal.NotNull;

public class Node<T extends Comparable> {

    @NotNull
    private T element;
    private int height;

    private Node<T> left;
    private Node<T> right;

    public Node(T element) {
        this.element = element;
        left = null;
        right = null;
        height = 0;
    }

    public Node() {
        element = null;
        height = 0;
        left = null;
        right = null;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int balanceFactor() {
        if (left != null && right == null) {
            return left.height;
        }
        if (left == null && right != null) {
            return right.height;
        }
        if (left == null && right == null) {
            return 0;
        }
        return left.height - right.height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }


    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", height=" + height +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
