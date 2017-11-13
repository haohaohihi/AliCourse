package cc.ipotato.reflect;

import java.util.Arrays;

public class GetSuperTest {
    public static void main(String[] args) {
        Class<?> cls = Apple.class;
        System.out.println(cls.getName());
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getSuperclass().getName());

        Class<?> interfaces[] = cls.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
    }
}
