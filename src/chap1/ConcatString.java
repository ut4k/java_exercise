package chap1;

public class ConcatString {

	public static void main(String[] args) {
        var result = "";
        for (var i = 0; i < 100000; i++)  {
            result += "いろは";
        }
		System.out.println(result);

	}

}
