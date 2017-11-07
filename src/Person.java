/**
 * Created by haohao on 17-10-2.
 */
public class Person {
    private String name;
    private int age;

    public static String ss = "sssssss";
    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getInfo(){
        return "name: " + this.name + ", age: " + this.age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    @Deprecated
    public void print(){
        System.out.println("print from Person");
    }

//    public abstract void fun();

//    @Override
//    public String toString(){
//        return "Person override";
//    }
    public static void main(String[] args) {
        Person p = new Person("hdafdh", 20);
        Person q = new Person("hh", 20);
        System.out.println(p);
        p.print();
        
//        System.out.println(p.getInfo());

    }
}
