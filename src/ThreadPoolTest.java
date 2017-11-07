import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int x = 0; x < 10; x++){
            int temp = x;
            try {
                Thread.sleep(1 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newCachedThreadPool.submit(() ->{
                System.out.println(Thread.currentThread().getName() + "、x = " + temp);
            });
        }
        newCachedThreadPool.shutdown();

        Runtime rt = Runtime.getRuntime();
        System.out.println(byteToM(rt.freeMemory()));
        System.out.println(byteToM(rt.maxMemory()));
        System.out.println(byteToM(rt.totalMemory()));

        String str = "";
        String str1 = "dsfaaaaaaaaaaaaaaaaaaaaaaaaafffffdsanvdvasdffffffff";


        System.out.println(byteToM(rt.freeMemory()));
        System.out.println(byteToM(rt.maxMemory()));
        System.out.println(byteToM(rt.totalMemory()));
    }

    public static double byteToM(long num){
        return (double) num/1024/1024;
    }
}
