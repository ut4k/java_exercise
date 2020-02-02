package chap1;
import java.math.BigDecimal;
import java.util.Arrays;

public class Compare {

    final static double EPSILON = 0.00001;

	public static void main(String[] args) {

        //compare object
        System.out.println("--object--");
        var builder1 = new StringBuilder("あいう");
        var builder2 = new StringBuilder("あいう");
        System.out.println(builder1 == builder2);

        //compare string
        System.out.println("--string--");
        var str1 = "あいう";
        var str2 = "あいう";
        System.out.println(str1 == str2);
        System.out.println(str1 == "あ" + "いう");

        //compare float
        System.out.println("--float--");
        System.out.println(0.2 * 3 == 0.6);

        //compare big decimal
        System.out.println("--big decimal--");
        var bd1 = new BigDecimal("0.2");
        var bd2 = new BigDecimal("3");
        var bd3 = new BigDecimal("0.6");
        System.out.println(bd1.multiply(bd2).compareTo(bd3)); //0 : 等しい

        //compare double
        System.out.println("--double--");
        var x = 0.2 * 3;
        var y = 0.6;
        System.out.println(Math.abs(x - y) < EPSILON); //0 : 等しい

        //compare array
        System.out.println("--array--");
        var data1 = new String[] { "あ", "い", "う" };
        var data2 = new String[] { "あ", "い", "う" };
        System.out.println(data1 == data2); //0 : 等しい
        System.out.println(data1.equals(data2)); //0 : 等しい

        //compare array deep
        var data1_ = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
        };
        var data2_ = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
        };
        System.out.println(Arrays.equals(data1_, data2_));
        System.out.println(Arrays.deepEquals(data1_, data2_));

        var data1__ = new int[] {1, 3};
        var data2__ = new int[] {1, 2, 3};
        var data3__ = new int[] {1, 2, 3};
        var data4__ = new int[] {1, 3, 1};
        System.out.println(Arrays.compare(data1__, data2__));
        System.out.println(Arrays.compare(data3__, data4__));
        System.out.println(Arrays.compare(data2__, data3__));

        System.out.println("--int--");
        //compare int
        Integer i1 = 108;
        Integer i2 = 108;
        System.out.println(i1 == i2);

        Integer j1 = 256;
        Integer j2 = 256;
        System.out.println(j1 == j2);

	}

}
