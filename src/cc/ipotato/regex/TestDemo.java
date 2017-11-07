package cc.ipotato.regex;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("x".matches("[0-9 ]"));
        String ip = "192.168.1.1";
        System.out.println(Arrays.toString(ip.split("\\.")));
    }
}
