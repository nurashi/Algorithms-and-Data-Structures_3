public class BST<K extends Comparable<K>, V> {
    private Node root;
    public class Node {
        public K key;
        public V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                current.val = value;
                return;
            }
        }
    }

    public V get(K key){
        Node current = root;
        while(current != null){
        
        }
    }
}