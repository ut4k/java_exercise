package chap5;
// import java.util.LocalDateTime;
// import java.util.Locale;
import java.util.regex.Pattern;

public class StringLibrary {

    public static void main(String[] args) {

        //== ながさ ==
        var str1 = "WINGSプロジェクト";
        System.out.println(str1.length()); //11

        var str2 = "叱る";
        System.out.println(str2.length()); //2
        System.out.println(str2.codePointCount(0, str2.length())); //2

        //== 比較 ==
        System.out.println("\n");
        var str = "def";
        System.out.println(str.compareTo("abc"));
        System.out.println(str.compareTo("def"));
        System.out.println(str.compareTo("xyz"));
        System.out.println(str.compareToIgnoreCase("DEF"));

        System.out.println("\n");
        str = "Wings";
        System.out.println(str.equals("WINGS"));
        System.out.println(str.equalsIgnoreCase("WINGS"));

        //== 空チェック ==
        System.out.println("\n");
        str1 = "";
        str2 = " 　  ";

        System.out.println(str1.isEmpty());
        System.out.println(str1.isBlank());
        System.out.println(str2.isEmpty());
        System.out.println(str2.isBlank());

        //== 除去 ==
        System.out.println("\n");
        str = "  Wings Project  ";
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());

        //== 検索 ==
        System.out.println("\n");
        str = "にわにはにわにわとりがいる";
        System.out.println(str.indexOf("にわ"));
        System.out.println(str.indexOf("にも"));
        System.out.println(str.lastIndexOf("にわ"));
        System.out.println(str.indexOf("にわ", 3));
        System.out.println(str.lastIndexOf("にわ", 3));

        System.out.println("\n");
        str = "WINGSプロジェクト";
        System.out.println(str.contains("プロ"));
        System.out.println(str.startsWith("WINGS"));
        System.out.println(str.startsWith("WINGS", 3));
        System.out.println(str.endsWith("WINGS"));

        //== 切り出し ==
        System.out.println("\n");
        System.out.println(str.substring(5, 7));
        // System.out.println(str.substring(5, 2)); //error
        // System.out.println(str.substring(-5)); //error
        // System.out.println(str.substring(15)); //error

        System.out.println("\n");
        var mail = "yamada@example.com";
        System.out.println(mail.substring(mail.lastIndexOf("@") + 1));

        System.out.println("\n");
        str = "叱る";
        System.out.println((int) str.charAt(0));

        //== 分割 ==
        str1 = "うめ,もも,さくら";
        var result1 = str1.split(",");
        System.out.println(String.join("&", result1));

        str2 = "うめ,もも,さくらとあんず";
        var result2 = str2.split("[,と]");
        System.out.println(String.join("&", result2));

        var str3 = "うめ,もも,さくら";
        var result3 = str3.split("");
        System.out.println(String.join("&", result3));

        var str4 = "うめ,もも,さくら,あんず";
        var result4 = str4.split(",", 3);
        System.out.println(String.join("&", result4));

        //== 整形 ==
        System.out.println("\n");
        System.out.println(String.format("%sは%s, %d歳です。", "さくら", "女の子", 1));
        System.out.println(String.format("名前は%1s, %3$d歳です。%1$sは、元気です。", "サクラ", "女の子", 1));
        //そのたいろいろ...

        //======= 正規表現 ======= 
        System.out.println("\n");
        var tel = new String[] { "080-0000-0000", "084-000-0000", "184-0000" };
        var rx = "\\d{2,4}-\\d{2,4}-\\d{4}";
        for (var t : tel) {
            System.out.println(Pattern.matches(rx, t) ? t : "アンマッチ");
        }

        str = "会社の電話は0123-99-0000です。自宅は000-123-4567だよ。";
        var ptn = Pattern.compile("(\\d{2,4})-(\\d{2,4})-(\\d{4})");
        var match = ptn.matcher(str);

        while (match.find()) {
            System.out.println("開始位置:" + match.start());
            System.out.println("終了位置:" + match.end());
            System.out.println("マッチング文字列" + match.group());
            System.out.println("市外局番" + match.group(1));
            System.out.println("市内局番" + match.group(2));
            System.out.println("加入者番号" + match.group(3));
            System.out.println("-----");
        }

        System.out.println("\n");
        str = "仕事用はwings@example.comです。プライベート用はYAMA@example.com。";
        ptn = Pattern.compile("[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9-]+(\\.[a-z0-9-]+)*", Pattern.CASE_INSENSITIVE);
        match = ptn.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
        }

        str = "10人のインディアン。\n1年生になったら";
        ptn = Pattern.compile("^\\d*");
        match = ptn.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
        }

        str = "初めまして。\nよろしくお願いします。";
        ptn = Pattern.compile("^.+");
        match = ptn.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
        }

        var tags = "<p><strong>WINGS</strong>サイト<a href='index.html'><img src='wings.jpg' /></a></p>";
        //最長一致
        // ptn = Pattern.compile("<.+>");
        //最短一致
        ptn = Pattern.compile("<.?>");
        match = ptn.matcher(tags);

        while   (match.find()) {
            System.out.println(match.group());
        }

        var msg = "会社の電話は0123-99-0000です。自宅は000-123-4567だよ。";
        ptn = Pattern.compile("(?<area>\\d{2,4})-(?<city>\\d{2,4})-(?<local>\\d{4})");
        match = ptn.matcher(msg);
        while (match.find()) {
          System.out.println("開始位置:" + match.start());  
          System.out.println("終了位置:" + match.end());  
          System.out.println("マッチング文字列:" + match.group());  
          System.out.println("市外局番:" + match.group("area"));  
          System.out.println("市内局番:" + match.group("city"));  
          System.out.println("加入者番号:" + match.group("local"));  
          System.out.println("-----");
        }

        str = "<p>サポートサイト<a href=\"https://www.wings.msn.to/\">https://www.wings.msn.to/</a></p>";
        ptn = Pattern.compile("<a href=\"(.+?)\">\\1</a>");
        match = ptn.matcher(str);
        if (match.find()) {
            System.out.println(match.group());
        }

        str = "仕事用はwings@example.comです。プライベート用はYAMA@example.comです。";
        ptn = Pattern.compile("([a-z0-9.!#$%&'*+/=?^_{|}~-]+)@([a-z0-9-]+(\\.[a-z0-9-]+)*)", Pattern.CASE_INSENSITIVE);
        match = ptn.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
            System.out.println(match.group(1));
            System.out.println(match.group(2));
            System.out.println(match.group(3));
            System.out.println("------");
        }

        //あと読み先読み
        var re1 = Pattern.compile("いろ(?=はに)");
        var re2 = Pattern.compile("いろ(?!はに)");
        var re3 = Pattern.compile("(?<=。)いろ");
        var re4 = Pattern.compile("(?<!。)いろ");

        var msg1 = "いろはにほへと";
        var msg2 = "いろものですね。いろいろと";

        myMatch(re1, msg1);
        myMatch(re1, msg2);

        myMatch(re2, msg1);
        myMatch(re2, msg2);

        myMatch(re3, msg1);
        myMatch(re3, msg2);

        myMatch(re4, msg1);
        myMatch(re4, msg2);

        //== 置換 ==
        str = "サポートサイトはhttps://www.wings.com.msn.to/です。";
        System.out.println(str.replaceAll("(?i)http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w ./?%&=-]*)?", "<a href=\"$0\">$0</a>"));

        str = "仕事用はwings@example.comです。";
        System.out.println(str.replaceAll(
                    "(?i)(?<localName>[a-z0-9.!#$%&'*+/=?^_{|}~-]+)@(?<domain>[a-z0-9-]+(?:\\.[a-z0-9-]+)*)" 
                    ,"${domain}の${localName}"
        ));

        str = "にわに3わうらにわに51わにわとりがいる";
        var re = Pattern.compile("\\d{1,}わ");
        var result = re.split(str);
        System.out.println(String.join(" ", result));
        

    }

    private static void myMatch(Pattern ptn, String input) {
        var match = ptn.matcher(input);
        while (match.find()) {
            System.out.println(match.group());
        }
        System.out.println("---");
    }

}
