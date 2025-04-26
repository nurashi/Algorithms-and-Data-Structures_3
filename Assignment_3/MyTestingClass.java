public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // defult custom of hash code, when prime number used to hash 
    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + id; 
        for (char c : name.toCharArray()) {
            result = 31 * result + c;
        }
        return result;
    }

}
