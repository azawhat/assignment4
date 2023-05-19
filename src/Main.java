public class Main {
    public static void main(String[] args)
    {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        for (int i = 0; i<10000; i++){
            MyTestingClass key  = new MyTestingClass(i);
            table.put(key, "value" + i);}

        table.replace(3,"S");

    }
}