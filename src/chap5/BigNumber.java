package chap5;
import java.math.BigInteger;

//
//long以上の整数を扱う
//
public class BigNumber {

    public static void main(String[] args) {
        var result = BigInteger.valueOf(1);
        for (var i = 1; i < 26; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            System.out.println(result);
        }
    }

}
