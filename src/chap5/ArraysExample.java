package chap5;
import java.util.Arrays;

//
//Arraysクラス
//ちょっとjsのArrayっぽい
//
public class ArraysExample {

    public static void main(String[] args) {

        var array1 = new String[] { "dog", "cat", "mouse", "fox", "lion" };
        Arrays.sort(array1);
        //文字にして表示
        System.out.println(Arrays.toString(array1));
        //値を検索
        System.out.println(Arrays.binarySearch(array1, "mouse"));

        var array2 = new String[] { "あ", "い", "う", "え", "お" };
        //コピー
        var array3 = Arrays.copyOf(array2, 2);
        System.out.println(Arrays.toString(array3));

        //範囲をコピー
        var array4 = Arrays.copyOfRange(array2, 1, 7);
        System.out.println(Arrays.toString(array4));

        //値を設定
        Arrays.fill(array4, 4, 6, "-");
        System.out.println(Arrays.toString(array4));

        //----------
        //シャローコピー
        //----------
        System.out.println("---シャローコピー---");
        var list1 = new StringBuilder[]{
            new StringBuilder("ドレミファソ"),
            new StringBuilder("CDEFG"),
            new StringBuilder("ハニホヘト")
        };

        var list2 = Arrays.copyOf(list1, list1.length);
        list1[2].append("イロハ");

        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2));

        list1 = null;
        list1 = new StringBuilder[]{
            new StringBuilder("ドレミファソ"),
            new StringBuilder("CDEFG"),
            new StringBuilder("ハニホヘト")
        };

        //----------
        //ディープコピー
        //----------
        System.out.println("---ディープコピー---");
        var list2_ = new StringBuilder[list1.length];
        for (var i = 0; i < list1.length; i++) {
            list2_[i] = new StringBuilder(list1[i].toString());
        }
        list1[2].append("イロハ");
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2_));

    }

}
