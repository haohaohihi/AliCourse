import java.util.Observable;
import java.util.Observer;

class House extends Observable{
    private double price;

    House(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        if (price > this.price){
            super.setChanged();
            super.notifyObservers(price);
        }
        this.price = price;
    }
}

class OPerson implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof House){
            if(arg instanceof Double){
                System.out.println("居民" + this + "观察到房价上涨，新价格：" + arg);
            }
        }
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        OPerson p1 = new OPerson();
        OPerson p2 = new OPerson();
        House house = new House(10000.0);
        house.addObserver(p1);
        house.addObserver(p2);
        house.setPrice(90999910);
    }
}
