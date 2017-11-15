package cc.ipotato.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;

class Student extends Person{
    public String sname;
}

public class GetFieldTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> cls = Student.class;
        Object obj = cls.newInstance();
//        Field[] fields = cls.getFields();
//        for(Field f: fields){
//            System.out.println(f);
//        }
        Field f = cls.getDeclaredField("sname");
        f.set(obj, "dd");
        System.out.println(f.get(obj));
    }
}
