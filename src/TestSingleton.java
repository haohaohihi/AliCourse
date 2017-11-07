class Singleton{
    private String a = "test";
    private final static Singleton INSTANCE = new Singleton();

    public static Singleton getInstance(){
        return INSTANCE;
    }
    private Singleton(){

    }
    public void print(){
        System.out.println("hello");
    }
}

public class TestSingleton {
    public static void main(String[] args) {
        Singleton s = null;
        s = Singleton.getInstance();
        s.print();
        int a = 10;
        int b = 30;
        int c;
        c = 100 + a + b;
        System.out.println(c);
    }
}
