package chap6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollAddAll {

    public static void main(String[] args) {

        //配列-->リスト（コピーで行う）
        var data = new String[] { "バラ", "ひまわり", "あさがお" };
        var list = new ArrayList<String>();
        Collections.addAll(list, data);
        list.set(0, "チューリップ");
        list.add("さくら");
        list.remove(1);

        System.out.println(list);
        System.out.println(Arrays.toString(data));

    }

}
