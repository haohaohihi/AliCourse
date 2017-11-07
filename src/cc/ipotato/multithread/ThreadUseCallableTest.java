package cc.ipotato.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadUseCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new ThreadUseCallable());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
