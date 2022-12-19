package org.example;
/**
 * appears analog of hashMap with keys of fixed type "long"
 * Includes two arrays - keys and values of the same length.
 * every index of these two arrays is an index of unique entry<keys[i]->values[i]>
 */
public class LongMapImpl<V> implements LongMap<V> {
    private long[] keys; // table of keys
    private V[] values; // table of values
    public LongMapImpl(){
        clear();
    }

    /**
     * if key already exists, changes Values node of corresponding to given key index of table Keys
     * else expands tables Keys and Values to one more cell and
     * put key and value to the last cell
     */
    public V put(long key, V value) {
        int oldLength = keys.length;
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] == key){
                values[i] = value;
                return value;
            }
        };
        // expanding tables of keys and values to one cell
        // is slow because of copying arrays after every put and remove,
        // but as less memory as possible
        expandEntries();
        keys[oldLength] = key;
        values[oldLength] = value;

        return value;
    }

    private void expandEntries(){
        long[] newKeys = new long[keys.length + 1];
        V[] newValues = (V[]) new Object[values.length + 1];
        for (int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    public V get(long key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i]==key) return values[i];
        };
        return null;
    }

    /**
     * if key doesn't exist, return null
     * else copies existing tables Keys and Values to tables of smaller size
     * excluding given key and corresponding to this key value from Values table
     */
    public V remove(long key) {
        if(!containsKey(key)){
            return null;
        }
        long[] newKeys = new long[keys.length - 1];
        V[] newValues = (V[]) new Object[values.length - 1];
        V val = null;
        int j = 0;
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != key) {
                newKeys[j] = keys[i];
                newValues[j] = values[i];
                j++;
            }
            else {
                val = values[i];
            }
        }
        keys = newKeys;
        values = newValues;
        return val;
    }

    public boolean isEmpty() {
        return keys.length==0;
    }

    public boolean containsKey(long key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i]==key){
                return true;
            }
        };
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i]==value){
                return true;
            }
        };
        return false;
    }

    public long[] keys() {
        return keys;
    }

    public V[] values() {
        return values;
    }

    public long size() {
        return keys.length;
    }

    public void clear() {
        keys = new long[0];
        values = (V[]) new Object[0];
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            sb.append("["+keys[i]+"->"+values[i]+"]");
        }
        return sb.toString();
    }
}
