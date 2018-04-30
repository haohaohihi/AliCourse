package cc.ipotato.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by haohao on 2018/4/29.
 */
public class RegexTestDemo1 {
    public static void main(String[] args) {
        String p = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)";
        System.out.println("192.124.21.33".matches(p));

        System.out.println(Pattern.matches(p, "221"));

        Pattern pp = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)");
        Matcher m = pp.matcher("192.168.1.1.199.199.199.200");
        while (m.find()) {
            System.out.println(m.group() + ": " + m.group(1) + "." + m.group(2));
        }
    }
}
