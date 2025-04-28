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
        //    System.out.println(arr[i]);
        }




        BST<Integer, String> bst = new BST<>();

        bst.put(5, "qwe");
        bst.put(3, "zxc");
        bst.put(7, "asd");
        bst.put(1, "123");
        bst.put(4, "!@$");
        System.out.println(bst.get(5)); 
        System.out.println(bst.get(3));
        System.out.println(bst.get(7));
        System.out.println(bst.get(1));
        System.out.println(bst.get(4));
        System.out.println(bst.get(10));

        System.out.println();
        System.out.println();
        System.out.println();
        Iterable<Integer> keys = bst.iterator();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        bst.delete(3); 
        System.out.println(bst.get(3)); 
        bst.delete(7); 
        System.out.println(bst.get(7)); 
        bst.delete(1);
        System.out.println(bst.get(1));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        keys = bst.iterator();
        for (Integer key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
