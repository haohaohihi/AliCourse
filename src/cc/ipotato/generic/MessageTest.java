package cc.ipotato.generic;

/**
 * Created by Hello on 2017/11/13.
 */

class Message<T>{
    private T note;

    public void setNote(T note) {
        this.note = note;
    }

    public T getNote() {
        return note;
    }
}

public class MessageTest {
    public static void main(String[] args) {
        Message<Integer> stringMessage = new Message<>();
        stringMessage.setNote(99);
        fun(stringMessage);
    }

    //泛型中的通配符使用
    public static void fun(Message<?> temp){
//        temp.setNote("hhhhh");  // 出错
        System.out.println(temp.getNote());
    }
}
