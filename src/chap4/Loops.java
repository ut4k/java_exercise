package chap4;

public class Loops {

    public static void main(String[] args) {

        for (var i = 1; i < 6; i++) {
            System.out.println(i + "番目のループです。");
        }

        for (int i = 1, j = 1; i < 6; i++, j++) {
            System.out.println(i * j);
        }

        _foreach();

    }

    public static void _foreach() {
        var data = new String[] { "うめ", "さくら", "もも" };

        //-- 通常のforループで
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

        //-- 拡張for
        for (var value : data) {
            System.out.println(value);
        }
    }

}
