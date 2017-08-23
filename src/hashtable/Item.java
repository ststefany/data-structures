package hashtable;

import com.sun.istack.internal.NotNull;

class Item<K, V> {

    @NotNull
    private final K key;
    private final V value;
    private int hash;

    public Item(K key, V value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "" + key + value;
    }
}
