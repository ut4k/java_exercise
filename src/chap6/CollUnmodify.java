package chap6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollUnmodify {

    public static void main(String[] args) {
        var data = new ArrayList<String>(Arrays.asList("バラ", "ひまわり", "あさがお"));
        var udata = Collections.unmodifiableList(data);
        // udata.set(0, "チューリップ"); //変更できないので例外
        // udata.add("さくら");
    }

}
