package chap6;
import java.util.ArrayList;

public class CollForeach {

    public static void main(String[] args) {
        var data = new ArrayList<String>() {
            {
                add("バラ");
                add("ひまわり");
                add("あさがお");
            }
        }; //代入式のおわりなのでセミコロンが必要
        System.out.println(data);

        for (var s : data) {
            System.out.println(s);
        }

        System.out.println("--------");

        //原始的なイテレータでイテレートする
        var itr = data.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("--------");

        //forで書く
        for (itr = data.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }
        System.out.println("--------");

        //要素を削除する
        var ite = data.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
            ite.remove();
        }
        System.out.println(data);

        System.out.println("--------");
        //拡張forでは削除できない
        //できる??
        for (var s : data) {
            System.out.println(s);
            data.remove(s);
        }
        System.out.println(data);
    }

}
