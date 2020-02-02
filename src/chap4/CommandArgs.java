package chap3;

public class CommandArgs {

    public static void main(String[] args) {
        int i = 0;
        for (var value : args) {
            System.out.println("arg" + i + " : " + value);
            i++;
        }
    }

}
