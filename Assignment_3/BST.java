import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size = 0; 

    public class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    size++;
                    return;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    size++;
                    return;
                }
                current = current.right;
            } else {
                current.value = value;
                return;
            }
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return current.value;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node target = root;
        Node parent = null;

        while (target != null && key.compareTo(target.key) != 0) {
            parent = target;
            if (key.compareTo(target.key) < 0) {
                target = target.left;
            } else {
                target = target.right;
            }
        }

        if (target == null) return;

        if (target.left == null) {
            if (parent == null) {
                root = target.right;
            } else if (parent.left == target) {
                parent.left = target.right;
            } else {
                parent.right = target.right;
            }
        } else if (target.right == null) {
            if (parent == null) {
                root = target.left;
            } else if (parent.left == target) {
                parent.left = target.left;
            } else {
                parent.right = target.left;
            }
        } else {
            Node successor = target.right;
            Node successorParent = target;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            target.key = successor.key;
            target.value = successor.value;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private Stack<Node> stack = new Stack<>();
            private Node current = root;

            @Override
            public boolean hasNext() {
                return current != null || !stack.isEmpty();
            }

            @Override
            public Entry<K, V> next() {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                Node node = stack.pop();
                Entry<K, V> entry = new Entry<>(node.key, node.value);
                current = node.right;
                return entry;
            }
        };
    }
}