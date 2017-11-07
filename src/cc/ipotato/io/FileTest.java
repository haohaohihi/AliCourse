package cc.ipotato.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File(File.separator + "home" + File.separator + "haohao" + File.separator + "create.txt");
//        if (file.exists()) {
//            file.delete();
//        }
//
//        if (!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length() / (double) 1024 / (double) 1024);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
        System.out.println(file.canRead());

        File parentFile = file.getParentFile();
        System.out.println(Arrays.toString(parentFile.listFiles()));
    }
}
