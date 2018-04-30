package cc.ipotato.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(new CompareByLen());
        set.add("aaaa");
        set.add("aaa");
        set.add("aaaaaaa");
        set.add("a");
        System.out.println(set);
    }
}

class CompareByLen implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        int num = s.length() - t1.length();
        return num == 0 ? num : s.compareTo(t1);
    }
}