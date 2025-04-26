public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> table = new MyHashTable<>(7);

        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("dada", 100);
        table.put("data", 200);
        table.put("123", 300);
        
        table.put("fgh", 250);
            
        // table.printTable();
        
        // System.out.println(table.get("banana"));
        // System.out.println(table.get("apple"));
        

        // System.out.println(table.get("notExist"));

        // System.out.println(table.remove("apple"));
        
        // System.out.println(table.remove("notExist"));
        
        // table.printTable();

        // System.out.println(table.contains(250));
        // System.out.println(table.contains(999));

        
        //System.out.println(table.getKey(250));
//        System.out.println(table.getKey(300));



        table.printTable();
    }
}
