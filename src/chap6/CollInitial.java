package chap6;
import java.util.ArrayList;

public class CollInitial {

    public static void main(String[] args) {

        var data = new ArrayList<String>() {
            {
                add("バラ");
                add("ひまわり");
                add("あさがお");
            }
        };
        System.out.println(data);
        //[バラ, ひまわり, あさがお]

    }

}
