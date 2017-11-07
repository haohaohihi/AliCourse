public class Student extends Person{

    public Student(String name, int age){
        super(name, age);
    }

    public String getInfo(){
        return "name: " + super.getName() + ", age: " + getAge();
    }

    public void print(){
        System.out.println("print from student");
    }

    public void fun(){
        System.out.println("fun");
    }

    public static void main(String[] args) {
        Student s = new Student("学生1", 7);
        Person p = new Student("学生2", 9);
//        Person sp =  new Person("学生3", 10);
//        Student spp = (Student) p;
        s.print();
        p.print();
//        sp.print();
        System.out.println(s.getInfo());
        System.out.println(Student.ss);
        s.fun(); 
    }
}
