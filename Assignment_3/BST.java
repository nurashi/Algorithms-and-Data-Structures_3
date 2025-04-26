import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    public class Node {
        public K key;
        public V val;
        private Node left, right;

        public Node(K key, V val) {
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

    public V get(K key) {
        Node current = root;
        while (current != null) {
            K currentKey = current.key;
            V currentVal = current.val;
            int campare = key.compareTo(currentKey);
            if (campare == 0) {
                return currentVal;
            } else if (campare < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;

        while (current != null && key.compareTo(current.key) != 0) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if(current == null){
            return;
        }

        if(current.left == null){
            if(parent == null){
                root = current.right;
            } else if(parent.left == current){
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if(current.right == null){
            if (parent == null) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            Node parent2 = current;
            Node node2 = current.right;
            while(node2.left != null){
                parent2 = node2;
                node2 = node2.left;
            }


            current.key = node2.key;
            current.val = node2.val;


            if(parent2.left == node2){
                parent2.left = node2.right;
            } else {
                parent2.right = node2.right;
            }
        }

    }

    public Iterable<K> iterator() {
        List<K> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current != null || !stack.isEmpty()){


            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.key);


            current = current.right;
        }


        return result;
    }
}