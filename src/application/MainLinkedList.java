package application;

import linkedlist.LinkedList;

import java.util.TreeMap;

public class MainLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a5");
        list.add("a6");

        System.out.println("Filled list: " + list);

        System.out.println("Size: " + list.size());


        //System.out.println(list.contains("a"));

        list.remove("a");

        System.out.println("List after \"a\"-element was removed: " + list);

        System.out.println("Size: " + list.size());
        System.out.println(list);

    }
}