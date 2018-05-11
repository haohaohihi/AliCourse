package cc.ipotato.Enum.MyEnum;

public class Test {
    public static void main(String[] args) {
//        demo1();
//        demo2();
        demo3();
    }

    private static void demo3() {
        Week3 mon = Week3.MON;
        Week3 tue = Week3.TUE;
        Week3 wed = Week3.WED;
        System.out.println(mon.getName());
        mon.show();
    }

    private static void demo2() {
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;
        System.out.println(mon.getName());
    }

    private static void demo1() {
        Week1 mon = Week1.MON;
        Week1 tue = Week1.TUE;
        Week1 wed = Week1.WED;
        System.out.println(mon);
    }

}
