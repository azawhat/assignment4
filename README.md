# Assignment 4
This is the fourth assignment of the course Algorithms and Data Structure

**_About MyTestingClass_**
**[Link](https://github.com/azawhat/assignment4/blob/master/src/MyTestingClass.java)**

1. New class is created to test `MyHashTable` and its name is `MyTestingClass`. It has one variable that is called `value` which is type integer. 
After that comes constructor that has the same name.



```
    private  int value;

    public MyTestingClass(int value) {
        this.value = value;
    }
```

2. Variable `value`has its getter and setter in the class

```
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
```

3. Then comes method `hashCode` that hashes the value using formula
```
    public int hashCode(){
        int result = 17;
        result = 31*result + value;
        return result;
    }
```


**_About MyHashTable_**
**[Link](https://github.com/azawhat/assignment4/blob/master/src/MyHashTable.java)**

1. This is the `hashTable` that contains the elements. It has 4 variables innit. They are `capacity`,`load_factor`,`buckets`,`size`.
The default capacity is 16. And load_factor that increases the size of the hashTable
After variables comes constructor with the same name.
```
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
```

2. `Put` method to put elements into the hash table. It gets index and adds them into the bucket.
If it is run out of the size, this method increases size by calling method `resize`

```
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
        if (size> buckets.length * load_factor){
            resize();
        }
    }
```

3. `get` method that gets value, indexes and bucket.
It has loop to get value of the key. 

```
    public V get(K key){
        int index = getIndex(key);
        List<Entry<K, V>> bucket = getBucket(index);
        for (Entry<K,V> entry: bucket) {
            if (entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }
```

4. `remove` method that removes entry from the `hashTable`.
```
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
```
5. `getIndex` method that is used to index of the element in the table.
```    
    private int getIndex(K key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode % buckets.length);
    }
```
7. 
8. `getBucket` method that gets the index of the bucket.
```
    private List<Entry<K,V>> getBucket(int index){
        if (buckets[index] == null){
            buckets[index] = new ArrayList<>();
        }
        return buckets[index];
    }
```
7. `resize` method that increases the size, when it reaches its maximum. It uses formula `buckets = new List[buckets.length * 2];` like that.
```
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
```
8. New class Entry. It has 2 variables, `K key` and `V value`.  After that comes constructor with the same name.
```
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
```
9. Setter and getter for both of the variables in the `Entry`
```
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
```