package chap1;

public class Shortcut {

	public static void main(String[] args) {
        String str = null;
        if (str != null && str.startsWith("http://"))  {
            System.out.println("「http://〜」で始まります。");
        }
        if (str != null & str.startsWith("http://"))  {
            System.out.println("「http://〜」で始まります。");
        }
	}

}
