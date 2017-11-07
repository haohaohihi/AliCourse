package cc.ipotato.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterTest {
    public static void main(String[] args) {
        File file = new File("TestFile" + File.separator + "test.txt");
        String msg = "啦啦啦那那那";
        try (Writer writer = new FileWriter(file)) {
//            writer.write(msg);
            writer.write(msg);
            writer.append(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
