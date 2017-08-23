package application;


import hashtable.HashTable;

import java.util.LinkedList;

public class MainHashtable {


    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable<>();
        table.put("s", "d");


        System.out.println(table);

        table.remove("s");

        System.out.println(table);

        table.put("s", "p");
        table.put("s", "w");

        System.out.println(table);
        System.out.println();

        table.put("s", "b");
        table.put("s1", "b");
        table.put("s2", "b");
        table.put("s3", "b");
        table.put("s4", "b");
        table.put("s5", "b");
        table.put("s52", "b");
        table.put("s53", "b");
        table.put("s5", "b");
        table.put("s6", "b");
        table.put("s7", "b");
        table.put("s8", "b");
        table.put("s9", "b");


        System.out.println(table);
        System.out.println("Capacity: " + table.getCapacity());
        System.out.println("Current load: " + table.getCurrentLoad());

        System.out.println("List of keys: " + table.getKeys());
        System.out.println("List of values: " + table.getValues());

        System.out.println(table.get("s"));


    }
}
