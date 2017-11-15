package cc.ipotato.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Class<?> cls = Class.forName("cc.ipotato.reflect.Person");
//        Method[] met = cls.getMethods();
//        for(Method m: met){
//            System.out.println(m);
//        }
        String attribute = "name";
        String value = "haohao";
        Object obj = cls.newInstance();

        Method setMethod = cls.getMethod("setName", String.class);
        setMethod.invoke(obj, value);

        Method getMethod = cls.getMethod("getName");
        Object result = getMethod.invoke(obj);
        System.out.println(result);
    }
}
