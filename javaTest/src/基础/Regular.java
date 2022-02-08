package 基础;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
//        // 要验证的字符串
//        String str = "service@xsoftlab.net";
//        // 邮箱验证规则
//        String regEx = "[a-zA-Z_]+[0-9]*@(([a-zA-z0-9]-*)+\\.){1,3}[a-zA-z\\-]+";
//        // 编译正则表达式
//        Pattern pattern = Pattern.compile(regEx);
//        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);// 忽略大小写的写法
//        Matcher matcher = pattern.matcher(str);
//        // 字符串是否与正则表达式相匹配
//        boolean rs = matcher.matches();
//        //boolean rs1 = Pattern.matches(regEx,str);//true
//        System.out.println(rs);
//
//        System.out.println("---------------");
//        String text = "A sep Text sep With sep Many sep Separators";
//        String patternString = "sep";
//        Pattern pattern1 = Pattern.compile(patternString);
//        以sep分隔字符串
//        String[] split = pattern1.split(text);
//        System.out.println("split.length = " + split.length);
//        for (String element : split) {
//            System.out.println("element = " + element);
//        }

//        System.out.println("=====================");
//        String text1 = "John writes about this, and John writes about that,"
//                    + " and John writes about everything. ";
//        String patternString1 = "(John)";
//        Pattern pattern2 = Pattern.compile(patternString1);
//        Matcher matcher2 = pattern2.matcher(text1);
//        while (matcher2.find()) {
//            System.out.println("found: " + matcher2.group(1));
//        }
        String str = "2890955982";
        // 邮箱验证规则
        String regEx = "^\\d{10}$";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);// 忽略大小写的写法
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        //boolean rs1 = Pattern.matches(regEx,str);//true
        System.out.println(rs);
        System.out.println(str.matches(regEx));
    }
}
