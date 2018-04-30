package cc.ipotato.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by haohao on 2018/4/29.
 */
public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("张三", 23);
        hm.put("李四", 24);
        hm.put("王五", 25);
        hm.put("赵六", 26);

        Set<HashMap.Entry<String, Integer>> entrySet = hm.entrySet();
        for (Map.Entry<String, Integer> es: entrySet) {
            System.out.println(es.getKey() + ": " + es.getValue());
        }
    }
}
