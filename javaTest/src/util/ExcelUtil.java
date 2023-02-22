package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ExcelUtil {
    /**
     * @author Claw
     * @date 2022/1/4 21:13.
     */

    public static void main(String[] args) {
        String str = "\"192.168.91.235\"";
        System.out.println(str);
        str = str.replaceAll("\"", "")
                .replaceAll("\n", "")
                .replaceAll("\r", "")
                .replaceAll(" ", "");

        System.out.println(str.split("\\.").length);
        String pattern = "^\\d{4,12}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str.replaceAll("\\.",""));
        System.out.println(m.find());
        System.out.println(str);
//        String pattern = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        System.out.println(m.matches());
//        String bString="181.116.222.88 192.168.1.1";
//        String regEx="((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
//        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher(bString);
//        if (m.find()) {
//            String result = m.group();
//            System.out.println(result);
//        }
//        Pattern pattern = Pattern.compile("\\.\"");
//        Stream<String> stringStream = pattern.splitAsStream(bString);
//        stringStream.forEach(System.out::println);


    }
}
