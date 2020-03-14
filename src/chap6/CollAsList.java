package chap6;
import java.util.Arrays;

public class CollAddAll {

    public static void main(String[] args) {

        var data = new String[] { "バラ", "ひまわり", "あさがお" };
        var list = Arrays.asList(data);
        list.set(0, "チューリップ");
        System.out.println(list);
        System.out.println(Arrays.toString(data));
        // list.add("さくら"); //エラー
        // list.remove(0); //エラー
    }

}
