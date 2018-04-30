package cc.ipotato.collection;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> hs = new HashSet<>();
        char[] ca = s.toCharArray();
        for(char c: ca) {
            hs.add(c);
        }
        System.out.println(hs);
    }
}
