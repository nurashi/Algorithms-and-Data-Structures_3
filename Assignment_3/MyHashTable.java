public class MyHashTable<K, V> {
    public HashNode<K, V>[] chainArray;
    public int M = 11;  // its a copacity
    public int size;

    public class HashNode<K, V> {
        public K key;
        public V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        String keyStr = key.toString();
        int hash = 0;
        for (int i = 0; i < keyStr.length(); i++) {
            hash = (hash * 31 + keyStr.charAt(i)) % M;
        }
        return hash;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; 
                return;
            }
            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    chainArray[index] = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public int size(){
        return size;
    }




    // its a just to be confident, to all data in
    public void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print(i + " -> ");
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                System.out.print(node + " -> ");
                node = node.next;
            }
            System.out.println("null");
        }
    }

}
