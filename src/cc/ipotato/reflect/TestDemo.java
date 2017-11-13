package cc.ipotato.reflect;

import java.util.Date;

public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 通过对象的getClass方法，获得对象的来源信息
        Date date = new Date();
        System.out.println(date.getClass());

        // 三种获取Class类实例化对象的方法
        Class<?> cls = new Date().getClass();
        System.out.println(cls);

        Class<?> clss = Date.class;
        System.out.println(clss);

        Class<?> clsss = Class.forName("java.util.Date");
        System.out.println(clsss);

        Object d = clsss.newInstance();
        System.out.println(d);
    }
}