package chap5;

public class Boxing1 {

	public static void main(String[] args) {

        //Longはlongのあやまり
		Long result = 0L;

        for (var i = 1; i < 10000; i++)  {
            //ボクシングとアンボクシングが発生するのでオーバーヘッド多い！
            result += i;
        }

        System.out.println(result);
		
	}

}
