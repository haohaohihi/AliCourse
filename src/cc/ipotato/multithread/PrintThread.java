package cc.ipotato.multithread;

class Data{
    private String title;
    private String note;
    private boolean has_data = false;

    public synchronized void get(){
        if(has_data == false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.title + "=" + this.note);
        has_data = false;
        notifyAll();
    }

    public synchronized void set(String title, String note){
        if(has_data == true ){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.note = note;
        has_data = true;
        notifyAll();
    }
}

class DataProvider implements Runnable{
    private Data data;

    public DataProvider(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for(int x = 0; x < 50; x++){
            if(x % 2 == 0){
                this.data.set("data1", "data1_note");
            }
            else{
                this.data.set("data2", "data2_note");
            }
        }
    }
}

class  DataConsumer implements Runnable{
    private Data data;

    public DataConsumer(Data data) {
        this.data = data;
    }

    public void run(){
        for(int x = 0; x < 50; x++){
            this.data.get();
        }
    }
}

 
public class PrintThread {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(new DataProvider(data)).start();
        new Thread(new DataConsumer(data)).start();
    }
}
