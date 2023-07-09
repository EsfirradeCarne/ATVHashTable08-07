public class HashTable {

    private BST<?> buckets[];

    public HashTable() {
        this.buckets = new BST<?>[3];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new BST<Pair>();
        }
    }

    private int hashFunction(int key) {
        return key % this.buckets.length;
    }

    public void put(int key, String value) {
        int b = this.hashFunction(key);
        BST<Pair> bucket = this.buckets[b];
        Pair pair = new Pair(key, value);
        bucket.insert(pair);
    }

    public String get(int key) {
        int b = this.hashFunction(key);
        BST<Pair> bucket = this.buckets[b];
        Pair pair = new Pair(key, null);
        Pair result = bucket.find(pair);
        if (result != null) {
            return result.getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        String out = "{\n";
        for (int i = 0; i < this.buckets.length; i++) {
            out += "\t" + this.buckets[i].toString() + "\n";
        }
        return out + "}";
    }

    public static void main(String[] args) {

        HashTable ht = new HashTable();
        System.out.println(ht.toString());
        ht.put(0, "a");
        System.out.println(ht.toString());
        ht.put(1, "b");
        System.out.println(ht.toString());
        ht.put(2, "c");
        System.out.println(ht.toString());
        ht.put(3, "d");
        System.out.println(ht.toString());
        ht.put(4, "e");
        System.out.println(ht.toString());
        ht.put(5, "f");
        System.out.println(ht.toString());

        System.out.println(ht.get(2));
        System.out.println(ht.get(10));

    }

}