package cc.ipotato.Enum.JdkEnum;

public class Test {
    public static void main(String[] args) {
//        demo1();
//        demo2();
        demo3();
    }

    private static void demo3() {
        Week3 mon = Week3.MON;
        System.out.println(mon);
        mon.show();
    }

    private static void demo2() {
        Week2 mon = Week2.MON;
        System.out.println(mon);
        System.out.println(mon.getName());
    }

    private static void demo1() {
        Week1 mon = Week1.MON;
        System.out.println(mon);
    }
}
