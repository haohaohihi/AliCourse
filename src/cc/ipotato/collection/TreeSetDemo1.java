package cc.ipotato.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hh");
        list.add("jj");
        list.add("kk");
        list.add("jj");
        list.add("hh");
        sort(list);
        System.out.println(list);
        char[] arr = {'a', 'b'};
        System.out.println(new String(arr));
    }

    public static void sort(List<String> list){
        TreeSet<String> ts = new TreeSet<>((s, t1) -> {
            int num = s.compareTo(t1);
            return num == 0 ? 1 : num;
        });
        ts.addAll(list);
        list.clear();
        list.addAll(ts);
    }
}
