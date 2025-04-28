import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<K> {
    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }
        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node(key, val);
                    size++;
                    break;
                }
                current = current.left;
            } else if (cmp > 0) {
                if (current.right == null) {
                    current.right = new Node(key, val);
                    size++;
                    break;
                }
                current = current.right;
            } else {
                current.val = val;
                break;
            }
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node parent = null;
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                parent = current;
                current = current.left;
            } else if (cmp > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) return;

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node minParent = current;
            Node min = current.right;
            while (min.left != null) {
                minParent = min;
                min = min.left;
            }
            current.key = min.key;
            current.val = min.val;
            if (minParent.left == min) {
                minParent.left = min.right;
            } else {
                minParent.right = min.right;
            }
        }
        size--;
    }

    @Override
    public Iterator<K> iterator() {
        LinkedList<K> keys = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            keys.add(current.key);
            current = current.right;
        }
        return keys.iterator();
    }
}