import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient String password;

    public static void main(String[] args) {

    }
    private void writeObject(ObjectOutputStream oos) throws Exception {
        // write the custom serialization code here
    }
}