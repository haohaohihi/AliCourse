package cc.ipotato.multithread;

import java.util.concurrent.Callable;

public class ThreadUseCallable implements Callable<String>{
    @Override
    public String call() throws Exception{
        for(int x = 0; x < 20; x++){
            System.out.println("x: " + x);
        }
        return "Stop";
    }
}
