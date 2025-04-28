import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(100);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int randomId = random.nextInt(100000);
            table.put(new MyTestingClass(randomId), i);
        }

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, Integer>.HashNode<MyTestingClass, Integer> node = table.chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            arr[i] = count;
        }

        for (int i = 0; i < arr.length; i++) {
            // System.out.println(arr[i]);
        }

        BST<Integer, String> bst = new BST<>();

        bst.put(15, "xyz");
        bst.put(5, "zxc");
        bst.put(20, "stu");
        bst.put(3, "vwx");
        bst.put(10, "bcd");
        System.out.println(bst.get(15));
        System.out.println(bst.get(5));
        System.out.println(bst.get(20));
        System.out.println(bst.get(3));
        System.out.println(bst.get(10));
        System.out.println(bst.get(7));

        System.out.println();
        System.out.println();
        System.out.println();
        Iterable<BST.Pair<Integer, String>> pairs = bst;
        for (BST.Pair<Integer, String> pair : pairs) {
            System.out.print(pair.getKey() + ":" + pair.getValue() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        bst.delete(5);
        System.out.println(bst.get(5));
        bst.delete(20);
        System.out.println(bst.get(20));
        bst.delete(10);
        System.out.println(bst.get(10));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        pairs = bst;
        for (BST.Pair<Integer, String> pair : pairs) {
            System.out.print(pair.getKey() + ":" + pair.getValue() + " ");
        }
        System.out.println();
    }
}
