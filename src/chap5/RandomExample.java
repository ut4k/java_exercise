package chap5;

import java.util.Random;

//乱数クラス
public class RandomExample {

    public static void main(String[] args) {
        //結果は実行のたびに異なる
        var rnd = new Random();
        System.out.println(rnd.nextBoolean());
        System.out.println(rnd.nextFloat());
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextInt(400) + 100);
        System.out.println(rnd.nextLong());

        var data = new byte[5];
        rnd.nextBytes(data);
        for (var b : data) {
            System.out.println(b + " ");
        }
    }

}
