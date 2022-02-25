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
////        String patternString1 = "John(?! writes)";
////        String patternString1 = ".*(?=John";
//        String patternString1 = ".*(?<=John)";
//        Pattern pattern2 = Pattern.compile(patternString1);
//        Matcher matcher2 = pattern2.matcher(text1);
//        while (matcher2.find()) {
//            System.out.println("found: " + matcher2.group());
//        }
//        String str = "2890955982@qq.com";
//        // 邮箱验证规则
////        String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
//        String regEx = "^(.*)$";
//        // 编译正则表达式
//        Pattern pattern = Pattern.compile(regEx);
//        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);// 忽略大小写的写法
//        Matcher matcher = pattern.matcher(str);
//        // 字符串是否与正则表达式相匹配
//        boolean rs = matcher.matches();
//        //boolean rs1 = Pattern.matches(regEx,str);//true
//        System.out.println(rs);
//        System.out.println(str.matches(regEx));
//        String test = "020-85653333";
//        String reg = "(0\\d{2})-(\\d{8})";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher mc = pattern.matcher(test);
//        if (mc.find() ){
//            System.out.println("分组的个数有：" + mc.groupCount());
//            for (int i = 0; i <= mc.groupCount();i++){
//                System.out.println("第" + i + "个分组为：" + mc.group(i));
//            }
//        }

//        String test = "aabbbbgbddesddfiid";
//        Pattern pattern = Pattern.compile("(\\w)\\1");
//        Matcher mc = pattern.matcher(test);
//        while (mc.find()) {
//            System.out.println(mc.group());
//        }

        String reg="\\d{3,6}";
        String test="61762828 176 2991 871";
        System.out.println("文本："+test);
        System.out.println("贪婪模式："+reg);
        Pattern p1 =Pattern.compile(reg);
        Matcher m1 = p1.matcher(test);
        while (m1.find()) {
            System.out.println("匹配结果：" + m1.group(0));
        }
    }
}
