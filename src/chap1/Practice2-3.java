package chap1;

public class Practice2_3 {

    public static void main(String[] args) {

        // -- 2 --
        var x = 6;
        var y = x;
        y -= 2;

        var builder1 = new StringBuilder("いろは");
        var builder2 = builder1;
        builder1.append("にほへと");

        System.out.println(builder1.toString());

        // -- 3 --
        String str = null;
        if (str != null && str.endsWith(".java")) {
            System.out.println("拡張子は.javaです");
        }

    }

}
