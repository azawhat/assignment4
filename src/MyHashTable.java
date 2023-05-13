import java.util.ArrayList;
import java.util.Map;

public class MyHashTable<K, V> {
    private static final int capacity = 16;
    private static final double load_factor = 0.75;

    private List<Entry<K,V>>[] buckets;
    private int size;

    public MyHashTable(){
        this(capacity);
    }

    public MyHashTable(int in_capacity) {
        buckets = new ArrayList[in_capacity];
        size = 0;
    }
}
