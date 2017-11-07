public class Link {
    private class Node{
        private Object data;
        private Node next;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(){}
        Node(Object data){
            this.data = data;
        }
    }

    private Node root = new Node();
    private Node current = new Node();

    public void add(Object data){
        if(data == null)    return;
        Node n = new Node(data);
        if(root == null) {
            root = n;
            current = n;
            return;
        }
        else{
            current.next = n;
            current = n;
        }
    }

    public static void main(String[] args) {

    }
}
