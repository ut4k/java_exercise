package chap6;
import java.util.ArrayList;
import java.util.Arrays;

public class CollToArray {

    public static void main(String[] args) {
        //コレクションを配列に変換
        var data = new ArrayList<String>(Arrays.asList("バラ", "ひまわり", "あさがお"));
        
        var strs = new String[data.size()];
        data.toArray(strs);

        data.set(0, "チューリップ");
        System.out.println(Arrays.toString(strs));
        System.out.println(data);

    }

}
