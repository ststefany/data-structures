package application;

import avl.AVLTree;

public class MainAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.put(2);
        tree.put(3);
        tree.put(9);
        tree.put(1);


        System.out.println(tree);
        System.out.println(tree.getRoot());

        tree.remove(tree.getRoot().getElement());

        System.out.println(tree);
        System.out.println(tree.getRoot());

    }
}
