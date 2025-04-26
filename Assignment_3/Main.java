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




        BST<Integer, String> tree = new BST<>();
        tree.put(5, "data");
        tree.put(2, "tata");
        tree.put(8, "qweqwe");
        tree.put(1, "zxczxc");
        tree.put(3, "asdasd");

        System.out.println(tree.size());

        for (var elem : tree) {
            System.out.println(elem.getKey() + " - " + elem.getValue());
        }

    }
}
