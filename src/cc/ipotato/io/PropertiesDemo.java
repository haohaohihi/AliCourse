package cc.ipotato.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
        demo3();
    }

    public static void demo1() {
        Properties pro = new Properties();
        pro.setProperty("name", "hh");
        pro.setProperty("tel", "1888888888");
        pro.setProperty("age", "22");
        System.out.println(pro);

        Enumeration<String> en = (Enumeration<String>) pro.propertyNames();
        while (en.hasMoreElements()) {
            String k = en.nextElement();
            System.out.println(k + ": " + pro.getProperty(k));
        }
    }

    public static void demo2() throws IOException {
        Properties pro = new Properties();
        pro.setProperty("name", "hh");
        pro.setProperty("tel", "1888888888");
        pro.setProperty("age", "22");
        System.out.println(pro);

        FileOutputStream fo = new FileOutputStream("TestFile/config.properties");
        pro.store(fo, "comments, xxx");
        fo.close();
    }

    public static void demo3() throws IOException{
        Properties pro = new Properties();
        FileInputStream fi = new FileInputStream("TestFile/config.properties");
        pro.load(fi);
        fi.close();
        System.out.println(pro);
    }
}
