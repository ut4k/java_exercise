package chap5;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileProcess {

    public static void main(String[] args) {

        var fs = FileSystems.getDefault();
        var path1 = fs.getPath("/Users/yuta/java_sample.txt");

        System.out.println(Files.exists(path1));
        System.out.println(Files.isReadable(path1));
        System.out.println(Files.isWritable(path1));
        System.out.println(Files.isExecutable(path1));
        // System.out.println(Files.size(path1));

        // var path2 = Files.copy(
        //         path1,
        //         fs.getPath("/Users/yuta/java_sample_copy.txt"),
        //         StandardCopyOption.REPLACE_EXISTING
        // );


    }

}
