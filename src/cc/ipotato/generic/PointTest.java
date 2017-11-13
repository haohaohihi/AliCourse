package cc.ipotato.generic;

/**
 * Created by Hello on 2017/11/13.
 */

class Point <T>{
    private T x;
    private T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class PointTest {
    public static void main(String[] args) {
        Point<String> p = new Point<String>("10", "30");
        System.out.println(p);
        Point<Integer> integerPoint = new Point<>(10, 20);
    }

}
