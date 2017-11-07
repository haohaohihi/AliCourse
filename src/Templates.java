import static java.lang.System.out;

class Messages<T>{
    private T note;

    Messages(T note){
        this.note = note;
    }

    public T getNote() {
        return note;
    }

    public void setNote(T note) {
        this.note = note;
    }
}

interface INewMessage<T>{

}

class NewMessageImpl<T> implements INewMessage<T>{
    public NewMessageImpl() {
    }
}

class NewMessageString implements INewMessage<String>{
    NewMessageString(){}
}

public class Templates {
    public static void main(String[] args) {
        Messages<Integer> m = new Messages<>(30);
        String s = "hhhh";
        fun(m);
        INewMessage<String> ll = new NewMessageString();
        tfun("ds", "dfs");
    }

    public static void fun(Messages<?> m){
        System.out.println(m.getNote());
    }

    public static <T> void tfun(T ... args){
        for(T t: args){
            System.out.println(t);
        }
        System.out.println(args);
    }

}
