public interface IMessage {
    public void print();
    String MSG = "hello";
}



class Message implements IMessage{
    public void print(){};
}