package cc.ipotato.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class Person{
    private String name;
    private int age;
    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class GetConstructorTest {
    public static void main(String[] args) {
        Class<?> cls = Person.class;
        Constructor<?>[] conts = cls.getConstructors();
        for(Constructor<?> c: conts){
            System.out.print(Modifier.toString(c.getModifiers()) + "  ");
            System.out.println(c);
            Class<?>[] params = c.getParameterTypes();
            for(Class<?> p: params){
                System.out.print(p.getName() + " ");
            }
            System.out.println();
        }
    }
}
