package chap6;
import java.util.TreeMap;

public class MapTreeSort {

    public static void main(String[] args) {
        var data = new TreeMap<String, String>(
                (x, y) -> x.length() - y.length()
        );

        data.put("Rose", "バラ");
        data.put("Sunflower", "ひまわり");
        data.put("Morning Glory", "あさがお");
        System.out.println(data);


    }

}
