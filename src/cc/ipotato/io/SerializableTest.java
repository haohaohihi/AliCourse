package cc.ipotato.io;

import java.io.*;

class Person implements Serializable{
    private transient String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        Person p = new Person("Helson", 22);
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("TestFile" + File.separator + "person.per")));
        oo.writeObject(p);
        oo.close();
        readObject();
    }

    public static void readObject() throws Exception {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("TestFile" + File.separator + "person.per")));
         System.out.println(ois.readObject());
         ois.close();
    }
}
