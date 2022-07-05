package 基础;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = StringUtil.humpToLine2("AAAAAAbB");
        System.out.println(a);
        String aaa = null;
        String bbb = null;
        System.out.println(Objects.equals(aaa,bbb));
    }
}
