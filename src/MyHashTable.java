import java.util.ArrayList;
import java.util.List;
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

    public void put(K key, V value) {
        int index = getIndex(key);
        List<Entry<K,V>> bucket = getBucket(index);
        for (Entry<K,V> entry: bucket) {
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key,value));
        size++;
        if (size>bucket.length*load_factor){
            resize();
        }
    }

    public V get(K key){
        int index = getIndex(key);
        List<Entry<K, V>> bucket = getBucket(index);
        for (Entry<K,V> entry: bucket) {
            if (entry.getKey().equals(key)){
                return entry.getValue;
            }
        }
        return null;
    }

    public void remvoe(K key){
        int index = getIndex(key);
        List<Entry<K, V>> bucket = getBucket(index);
        for (Entry<K,V> entry: bucket){
            if (entry.getKey().equals(key)){
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    private int getIndex(K key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    private List<Entry<K,V>> getBucket(int index){
        if (buckets[index] == null){
            buckets[index] = new ArrayList<>();
        }
        return buckets[index];
    }


    private void resize(){
        List<Entry<K,V>>[] oldBuckets = buckets;
        buckets = new List[buckets.length * 2];
        size = 0;
        for (List<Entry<K,V>> bucket: oldBuckets){
            if (bucket != null) {
                for (Entry<K,V> entry: bucket) {
                    put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private static class Entry<K,V>{
        private K key;
        private V value;


    }
}
