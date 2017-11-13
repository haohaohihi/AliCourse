package cc.ipotato.generic;

import java.awt.image.ImageConsumer;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Hello on 2017/11/13.
 */
interface IMessage<T>{
    public void print(T t);
}

//泛型接口的实现之一：实现类仍使用泛型
class GMessageImpl<T> implements IMessage<T>{
    @Override
    public void print(T t){
        System.out.println(t);
    }
}

//泛型接口的实现之二：实现类具体化泛型参数
class SMessageImpl implements IMessage<String>{
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
public class GenericInterfaceTest {
    public static void main(String[] args) {
        GMessageImpl<String> gm = new GMessageImpl<>();
        gm.print("hello");
        new SMessageImpl().print("lllll");

        System.out.println(Arrays.toString(fun(new Integer[]{1,2,3})));
    }


    //泛型函数
    public static<T> T[] fun(T ...args){
        return args;
    }
}

