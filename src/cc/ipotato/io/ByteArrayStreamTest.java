package cc.ipotato.io;

import java.io.*;

/**
 * Created by Hello on 2017/11/8.
 */
public class ByteArrayStreamTest {
    public static void main(String[] args) throws IOException {
        String string = "hello";
        OutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        int temp = 0;
        while ((temp = inputStream.read()) != -1){
            outputStream.write(Character.toUpperCase(temp));
        }
        System.out.println(outputStream);
        outputStream.close();
        inputStream.close();
    }
}
