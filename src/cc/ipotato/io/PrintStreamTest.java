package cc.ipotato.io;

import java.io.*;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[10];
        int temp = 0;
        while ((temp = in.read(data)) != -1){
            System.out.println(new String(data));
            System.out.println(temp);
            bos.write(data, 0, temp);
        }
        System.out.println(new String(bos.toByteArray()));
        in.close();
        bos.close();
    }
}
