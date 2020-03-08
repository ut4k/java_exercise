package chap5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.LocalDateTime;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamLibrary {

    public static void main(String[] args) {

        //ログ出力(ファイル書き込み)
        try (var writer = Files.newBufferedWriter(Paths.get("/Users/yuta/java_logtest.log"))){
            writer.write(LocalDateTime.now().toString()); 
            writer.newLine();
        } catch(Exception e) {
            e.printStackTrace();

        }
        //try-with-resources構文

        //ファイル読み込み 
        try (var reader = Files.newBufferedReader(
                    Paths.get("/Users/yuta/java_sample.txt"))) {
            var line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();

        }

        //バイナリデータ
        //画像のバイナリデータをコピーする
        try (
            var in = new BufferedInputStream(new FileInputStream("/Users/yuta/Pictures/748508.jpg"));
            var out = new BufferedOutputStream(new FileOutputStream("/Users/yuta/Pictures/748508_copy.jpg"))) {
            //1行ずつ転機
            var data = -1;
            while ((data = in.read()) != -1) {
                out.write((byte) data);
            }
        } catch(Exception e) {
            e.printStackTrace();

        }


    }

}
