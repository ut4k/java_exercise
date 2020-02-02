package chap1;
import java.math.BigDecimal;

public class Calc {

	public static void main(String[] args) {
        
        // -- division --
        System.out.println(3 / 4);
        // System.out.println(5 / 0); //divide by zero error
        // System.out.println(5 % 0); //divide by zero error
        System.out.println(5d / 0); //Infinity
        System.out.println(5d % 0); //Nan

        // -- float --
        System.out.println(Math.floor((0.7 + 0.1) * 10)); //7.99999... -> 8になってしまう

        // -- big decimal --
        var bd1 = new BigDecimal("0.7");
        var bd2 = new BigDecimal("0.1");
        var bd3 = new BigDecimal("10");
        System.out.println("BigDecimal:");
        System.out.println(bd1.add(bd2).multiply(bd3));


    }
}
