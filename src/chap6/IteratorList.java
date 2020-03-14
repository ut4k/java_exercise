package chap6;
import java.util.ArrayList;

public class IteratorList {

    public static void main(String[] args) {
        var data = new ArrayList<String>() {
            {
                add("バラ");
                add("ひまわり");
                add("あさがお");
            }
        };

        var ite = data.listIterator(data.size());
        //逆順に出力
        while (ite.hasPrevious()) {
            System.out.println(ite.previous());
        }

    }

}
