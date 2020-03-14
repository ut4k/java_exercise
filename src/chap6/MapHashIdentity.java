package chap6;
import java.util.HashMap;

public class MapHashIdentity {

    public static void main(String[] args) {
        var key1 = Integer.valueOf(256);
        var key2 = Integer.valueOf(256);

        var data = new HashMap<Integer, String>() {
            {
                put(key1, "Hoge");
                put(key2, "Foo");
            }
        };

        System.out.println(data);
    }

}
