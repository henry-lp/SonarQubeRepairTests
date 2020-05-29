import java.io.Serializable;
public class SerializableFieldProcessorTest implements Serializable {
    private Unser uns;// Noncompliant


    public static void doNothing() {
        int x = 500;
    }
}