package cc.ipotato.multithread;

public class MyThread extends Thread {
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run(){
        for(int x = 0; x < 1000; x++){
            System.out.println(this.title + ", x = " + x);
        }
    }
}
