package cc.ipotato.reflect;

interface IFruit {
    public void eat();
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements IFruit {
    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

class OldFactory{
    // 传统工厂类，需要对className进行判断再实例化对象，原罪在于new
    private OldFactory(){};
    public static IFruit getInstance(String className){
        if("apple".equals(className)){
            return new Apple();
        }
        else if("orange".equals(className)){
            return new Orange();
        }
        else {
            return null;
        }
    }
}

class NewFactory{
    private NewFactory(){};
    public static IFruit getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        IFruit fruit = null;
        Class cls = Class.forName(className);
        fruit = (IFruit) cls.newInstance();
        return fruit;
    }
}

class NewFactoryWithGeneric{
    private NewFactoryWithGeneric(){}
    public static <T> T getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        T t = null;
        Class cls = Class.forName(className);
        t = (T) cls.newInstance();
        return t;
    }
}

public class FactoryTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IFruit apple = OldFactory.getInstance("apple");
        apple.eat();

        NewFactory.getInstance("cc.ipotato.reflect.Orange").eat();
        IFruit orange =  NewFactoryWithGeneric.getInstance("cc.ipotato.reflect.Orange");
        orange.eat();
    }
}
