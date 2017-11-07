package cc.ipotato.multithread;

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("threa a");
        MyThread mt2 = new MyThread("threa b");
        MyThread mt3 = new MyThread("threa c");
        MyThread mt4 = new MyThread("threa d");
        MyThread mt5 = new MyThread("threa e");
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
    }
}
