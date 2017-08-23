package hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HashTable<K, V> {
    private int capacity;
    private double loadFactor;
    private Item<K, V>[] table;
    private int currentLoad = 0;

    public HashTable(int capacity, double loadFactor) {
        validateArguments(capacity, loadFactor);

        this.capacity = capacity;
        this.loadFactor = loadFactor;
        table = new Item[capacity];

        initializeWithNulls();
    }


    public HashTable() {
        this(10, 0.8);
    }

    public V get(K key) {
        int index = key.hashCode() % capacity;

        while (table[index] != null && table[index].getKey() != key)
            index = (index + 1) % capacity;
        if (table[index] == null)
            return null;
        else
            return table[index].getValue();
    }

    public void put(K key, V value) {
        if (currentLoad > capacity * loadFactor) {
            rehash();
        }

        int hash = key.hashCode();
        int index = hash % capacity;

        while (table[index] != null && table[index].getKey() != key) {
            index = (index + 1) % capacity;
        }
        table[index] = new Item<>(key, value, hash);
        recountCurrentLoad();
    }

    public void remove(K key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            if (key.equals(table[i].getKey())) {
                table[i] = null;
            }
        }
        recountCurrentLoad();
    }


    public Collection<V> getValues() {
        List<V> result = new ArrayList<>();
        for (Item item : table) {
            if (item != null) {
                result.add((V) (item.getValue()));
            }
        }
        return result;
    }

    public Collection<K> getKeys() {
        List<K> result = new ArrayList<>();
        for (Item item : table) {
            if (item != null) {
                result.add((K) (item.getKey()));
            }
        }
        return result;

    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    private void rehash() {
        capacity = (int) (capacity * 1.5);
        currentLoad = 0;

        Item<K, V>[] tempTable = table;
        table = new Item[capacity];

        initializeWithNulls();
        for (Item item : tempTable) {
            if (item != null) {
                put((K) item.getKey(), (V) item.getValue());
            }
        }
        recountCurrentLoad();
    }

    private void recountCurrentLoad() {
        currentLoad = 0;
        for (Item i : table) {
            if (i != null) {
                currentLoad++;
            }
        }
    }

    private void validateArguments(int initialCapacity, double loadFactor) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        if (loadFactor <= 0 || Double.isNaN(loadFactor))
            throw new IllegalArgumentException("Load factor cannot be less than 0");
    }

    private void initializeWithNulls() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (Item i : table) {
            if (i == null) {
                continue;
            }
            builder.append(i.getKey());
            builder.append(" = ");
            builder.append(i.getValue());
            builder.append(", ");
        }
        builder.append("}");
        String result = builder.toString();
        result = result.replace(", }", "}");
        return result;
    }
}
