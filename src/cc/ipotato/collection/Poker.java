package cc.ipotato.collection;

import java.util.*;

public class Poker {
    public static void main(String[] args) {
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"黑桃", "红桃", "方块", "梅花"};

        List<Integer> deal = new ArrayList<>();
        Map<Integer, String> poker = new HashMap<>();
        int index = 0;
        for (String n: number) {
            for (String c: color) {
                poker.put(index, c + n);
                deal.add(index++);
            }
        }
        poker.put(index, "大王");
        deal.add(index++);
        poker.put(index, "小王");
        deal.add(index);

        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        List<String> p3 = new ArrayList<>();
        List<String> other = new ArrayList<>();

        Collections.shuffle(deal);
        for (int i = 0; i < poker.size(); i++) {
            if (i >= poker.size() - 3 ) {
                other.add(poker.get(deal.get(i)));
            } else if (i % 3 == 0) {
                p1.add(poker.get(deal.get(i)));
            } else if (i % 3 == 1) {
                p2.add(poker.get(deal.get(i)));
            } else {
                p3.add(poker.get(deal.get(i)));
            }
        }

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(other);

    }
}
