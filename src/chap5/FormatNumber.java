package chap5;
import java.text.NumberFormat;
import java.text.Format;

public class FormatNumber {

    public static void main(String[] args) {
        var num1 = 1234.5678;
        // var nf1 = NumberFormat.getCurrencyInstance(Locale.JAPAN); //通貨フォーマット エラーになる?
        var nf2 = NumberFormat.getIntegerInstance();
        var nf3 = NumberFormat.getNumberInstance();
        // System.out.println(nf1.format(num1));
        System.out.println(nf2.format(num1));
        System.out.println(nf3.format(num1));

        var num2 = 0.567;
        var nf4 = NumberFormat.getPercentInstance();
        System.out.println(nf4.format(num2));
    }

}
