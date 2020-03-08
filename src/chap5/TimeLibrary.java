package chap5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import java.time.Month;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import java.util.Locale;

import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.format.DateTimeFormatter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class TimeLibrary {

    public static void main(String[] args) {
        //現在日付生成
        System.out.println(LocalDateTime.now());
        System.out.println(OffsetDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());

        //指定された日付から生成
        var ldt1 = LocalDateTime.of(2019, 1, 10, 10, 20, 30, 513); 
        var ldt2 = LocalDateTime.of(2019, Month.JANUARY, 10, 10, 20, 30);
        // var ldt3 = LocalDateTime.of(2019, 1, 40, 10, 20, 30); //error
        System.out.println(ldt1);
        System.out.println(ldt2);
        // System.out.println(ldt3); //error

        var ld = LocalDate.of(2019, 1, 10);
        System.out.println(ld);

        var lt = LocalTime.of(10, 20, 30);
        System.out.println(lt);

        var ldt4 = LocalDateTime.of(ld, lt);
        System.out.println(ldt4);

        var odt = OffsetDateTime.of(2019, 1, 10, 10, 20, 30, 999, ZoneOffset.ofHours(9));
        System.out.println(odt);

        var ot = OffsetTime.of(10, 20, 30, 999, ZoneOffset.ofHours(9));
        System.out.println(ot);

        var zdt = ZonedDateTime.of(2019, 1, 10, 10,20, 30, 999, ZoneId.of("Asia/Tokyo"));
        System.out.println(zdt);

        //利用できるタイムゾーンリスト
        for (var id : ZoneId.getAvailableZoneIds()) {
            // System.out.println(id);
        }

        //文字列から変換
        System.out.println(LocalDate.parse("2019-01-10", DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.parse("2019-123", DateTimeFormatter.ISO_ORDINAL_DATE));
        System.out.println(LocalDate.parse("2019-W40-5", DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(ZonedDateTime.parse("2019-01-10T10:20:30.000000999+09:00[Asia/Tokyo]", DateTimeFormatter.ISO_DATE_TIME));

        //日付を比較する
        var dt1 = LocalDateTime.of(2018, 12, 31, 10, 20, 30);
        var dt2 = LocalDateTime.of(2019, 1, 10, 10, 20, 30);

        System.out.println(dt1.equals(dt2));
        System.out.println(dt1.isBefore(dt2));
        System.out.println(dt1.isAfter(dt2));

        //年月日時分秒を取得する
        var dt = LocalDateTime.of(2019, 1, 10, 10, 20, 30, 123);
        System.out.println(
                dt.getYear() + "年" +
                dt.getMonthValue() + "月" +
                dt.getDayOfMonth() + "日" +
                dt.getDayOfWeek() + " " +
                dt.getHour() + "時" +
                dt.getMinute() + "分" +
                dt.getSecond() + "秒" +
                dt.getNano() + "ナノ秒"
        );
        System.out.println("月名は" + dt.getMonth() + " 今年" + dt.getDayOfYear() + "日目");

        var dt_ = LocalDateTime.of(2019, 1, 10, 10, 20, 30, 123);
        var week = new String[] {
            "日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"
        };

        System.out.println(
            dt_.get(ChronoField.YEAR) + "年" +
            dt_.get(ChronoField.MONTH_OF_YEAR) + "月" +
            dt_.get(ChronoField.DAY_OF_MONTH) + "日" +
            week[dt_.get(ChronoField.DAY_OF_WEEK) -1] + " " +
            dt_.get(ChronoField.HOUR_OF_DAY) + "時" +
            dt_.get(ChronoField.MINUTE_OF_HOUR) + "分" +
            dt_.get(ChronoField.SECOND_OF_MINUTE) + "秒" +
            dt_.get(ChronoField.NANO_OF_SECOND) + "ナノ秒"
        );

        var dt_1 = LocalDateTime.of(2019, 1, 10, 10, 20, 30); 
        var dt_2 = ZonedDateTime.of(2019, 1, 10, 10, 20, 30, 0, ZoneId.of("Asia/Tokyo")); 

        //フォーマットして表示
        System.out.println(dt_1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(dt_2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(dt_1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(dt_2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

        //自前のフォーマットで表示
        System.out.println(dt_1.format(DateTimeFormatter.ofPattern("y.M.dd H:m:s")));
        System.out.println(dt_2.format(DateTimeFormatter.ofPattern("Y年L月d日 (E) a K時 m分s秒(z)")));


        //標準フォーマット or 独自フォーマット
        var locale = Locale.JAPAN;
        var zone = ZoneId.of("Asia/Tokyo");
        var dt3 = ZonedDateTime.of(LocalDateTime.now(), zone);

        //標準のフォーマットの方がロケールに合わせて適切な文字を出してくれる
        System.out.println(dt3.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale)));
        System.out.println(dt3.format(DateTimeFormatter.ofPattern("Y年L月d日(E) a K時m分s秒(z)", locale)));

        //日本時間用クラス
        var d = JapaneseDate.of(JapaneseEra.HEISEI, 30, 12, 31);
        System.out.println(d);
        var df = DateTimeFormatter.ofPattern("Gy年MM月dd日");
        System.out.println(d.format(df));

        //差分を取得
        var dt01 = LocalDateTime.of(2018, 12, 31, 0, 0, 0);
        var dt02 = LocalDateTime.of(2020, 3, 3, 10, 20, 30);

        var period = Period.between(dt01.toLocalDate(), dt02.toLocalDate());
        System.out.println(
            "日付の差:" +
            period.getYears() + "年" +
            period.getMonths() + "ヶ月" +
            period.getDays() + "日間"
        );

        var duration = Duration.between(dt01, dt02);
        System.out.println("時間の差:" + duration.toHours() + "時間");

        //減算・加算
        var day = LocalDate.of(2019, 1, 10);
        System.out.println(day);
        System.out.println(day.plus(3, ChronoUnit.YEARS));
        System.out.println(day.minus(21, ChronoUnit.DAYS));

        //periodやdurationを渡して計算する
        var day2 =LocalDateTime.of(2019, 1, 10, 10, 20, 30);
        var period2 = Period.ofYears(3);
        var duration2 = Duration.parse("P21DT1H1M1S");
        System.out.println(day2);
        System.out.println(day2.plus(period2));
        System.out.println(day2.minus(duration));



    }

}
