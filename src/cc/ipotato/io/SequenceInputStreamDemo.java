package cc.ipotato.io;

import java.io.*;

public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException{
        InputStream is1 = new FileInputStream("TestFile/a.txt");
        InputStream is2 = new FileInputStream("TestFile/b.txt");
        InputStream sis = new SequenceInputStream(is1, is2);

        OutputStream os = new FileOutputStream("TestFile/c.txt");
        int d;
        while ((d = sis.read()) != -1) {
            os.write(d);
        }

        os.close();
        sis.close();
    }
}
