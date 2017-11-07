package cc.ipotato.io;

import java.io.*;

public class StreamTest {
    public static void main(String[] args) {
        File file = new File("TestFile" + File.separator + "test.txt");
//        if (!file.getParentFile().exists())
//            file.getParentFile().mkdirs();
//
//        try {
//            OutputStream outputStream = new FileOutputStream(file, true);
//            String msg = "welcome to ipotato.cc\r\n";
//            outputStream.write(msg.getBytes(), 0, 10);
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//
//        }
        byte[] data = new byte[10];
        try (InputStream inputStream = new FileInputStream(file)) {
            while(inputStream.read(data) != -1){
                System.out.println(new String(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
